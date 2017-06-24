package com.example.wangxiao.a20cameraalbumtest

import android.annotation.TargetApi
import android.app.Activity
import android.content.ContentUris
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.BitmapFactory.decodeStream
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.content.FileProvider
import android.text.Selection
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import java.io.*
import java.net.URI
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    val TAKE_PHOTO: Int = 1
    var picture: ImageView? = null
    var imageUri: Uri? = null

    var CHOOSE_PHOTO: Int = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var takePhoto = findViewById(R.id.take_photo) as Button
        picture = findViewById(R.id.image_view) as ImageView
        takePhoto.setOnClickListener {



            val outputImage: File = File(externalCacheDir, "output_image.jpg")

            try {
                if (outputImage.exists()) {
                    outputImage.delete()
                }
                outputImage.createNewFile()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            if (Build.VERSION.SDK_INT >= 24) {
                imageUri = FileProvider.getUriForFile(this, "com.example.wangxiao.a20cameraalbumtest.fileprovider", outputImage)
            } else {
                imageUri = Uri.fromFile(outputImage)
            }
            println("------------------ ${imageUri}")
            /// 启动应用
            var intent = Intent("android.media.action.IMAGE_CAPTURE")
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
            startActivityForResult(intent, TAKE_PHOTO)
        }

        var chooseFromAlbum = findViewById(R.id.choose_from_album) as Button
        chooseFromAlbum.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {

                var ll = arrayOf<String>(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        //mutableListOf<String>()

                ActivityCompat.requestPermissions(this, ll, 1)
            } else {
                openAlbum()
            }
        }
    }

    /* 打开相册 */
    fun openAlbum() {
        var intent = Intent("android.intent.action.GET_CONTENT")
        intent.setType("image/*")
        startActivityForResult(intent, CHOOSE_PHOTO)
    }

    /* 相册权限 */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 1) {
            if (grantResults.count() > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openAlbum()
            } else {
                Toast.makeText(this, "没有权限", Toast.LENGTH_SHORT).show()
            }
        }
    }


    //////////  成功回调
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        println("QQQQQQQQQQQ]======================")
        if (requestCode == TAKE_PHOTO) {
            if (resultCode == Activity.RESULT_OK) {
                try {
                    var bitmap: Bitmap = decodeStream(contentResolver.openInputStream(imageUri))
                    var height: Int = bitmap.getHeight() as Int
                    var width: Int = bitmap.getWidth() as Int
                    picture?.setImageBitmap(comp(bitmap))
                } catch (e: FileNotFoundException) {
                    e.printStackTrace()
                }
            }
        } else if (requestCode == CHOOSE_PHOTO) {
            if (resultCode == Activity.RESULT_OK) {


                if (Build.VERSION.SDK_INT >= 19) {
                    /// 4.4 上
                    if (data != null)
                        handleImageOnKitKat(data)
                } else {
                    /// 4.4 下
                    if (data != null)
                        handleImageBeforeKitKat(data)
                }
            }
        }
    }

    @TargetApi(19)
    fun handleImageOnKitKat(data: Intent) {
        var imagePath: String = ""
        var uri: Uri = data.data

        if (DocumentsContract.isDocumentUri(this, uri)) {

            var docId: String = DocumentsContract.getDocumentId(uri)
            if ("com.android.providers.media.documents".equals(uri.authority)) {
                var id: String = docId.split(":")[1]
                var selection: String = MediaStore.Images.Media._ID + "=" + id

                imagePath = getImagePath2(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection)
                        //getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection)
            } else if ("com.android.providers.downloads.documents".equals(uri.authority)) {
                var contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), docId.toLong())
                imagePath = getImagePath2(contentUri, null)
            }
        } else if ("content".equals(uri.scheme, true)) {
            imagePath = getImagePath2(uri, null)
        } else if ("file".equals(uri.scheme, true)) {
            imagePath = uri.path
        }

        displayImage(imagePath)
    }

    fun handleImageBeforeKitKat(data: Intent) {
        var uri: Uri = data.data
        var imagePath = getImagePath2(uri, null)
        displayImage(imagePath)
    }


    fun getImagePath2(uri: Uri, selection: String?): String {

        var path: String = ""

        var cursor: Cursor = contentResolver.query(uri, null, selection, null, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
            }
            cursor.close()
        }
        return path
    }

    fun displayImage(imagePath: String) {
        if (imagePath != null) {
            var bitmap: Bitmap = BitmapFactory.decodeFile(imagePath)
            picture?.setImageBitmap(bitmap)
        } else {
            Toast.makeText(this, "获取图片失败", Toast.LENGTH_SHORT).show()
        }
    }










    /* 压缩图片 */
    private fun compressImage(image: Bitmap): Bitmap {
        val baos = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.JPEG, 10, baos)//质量压缩方法，这里100表示不压缩，把压缩后的数据存
        val isBm = ByteArrayInputStream(baos.toByteArray())//把压缩后的数据baos存放到ByteArrayInputStream中
        val bitmap = decodeStream(isBm, null, null)//把ByteArrayInputStream数据生成图片
        return bitmap
    }
    /* 压缩图片 */
    private fun comp(image: Bitmap): Bitmap {

        val baos = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.JPEG, 50, baos)
//
//        if (baos.toByteArray().length / 1024 > 1024) {//判断如果图片大于1M,进行压缩避免在生成图片（BitmapFactory.decodeStream）时溢出
//            baos.reset()//重置baos即清空baos
//            image.compress(Bitmap.CompressFormat.JPEG, 50, baos)//这里压缩50%，把压缩后的数据存放到baos中
//        }
        var isBm = ByteArrayInputStream(baos.toByteArray())
        val newOpts = BitmapFactory.Options()
//        //开始读入图片，此时把options.inJustDecodeBounds 设回true了
//        newOpts.inJustDecodeBounds = true
        var bitmap = BitmapFactory.decodeStream(isBm, null, newOpts)
//        newOpts.inJustDecodeBounds = false
//        val w = newOpts.outWidth
//        val h = newOpts.outHeight
//        //现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
        val hh = 800f//这里设置高度为800f
        val ww = 480f//这里设置宽度为480f
//        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        var be = 1//be=1表示不缩放
//        if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放
            be = (newOpts.outWidth / ww).toInt()
//        } else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放
            be = (newOpts.outHeight / hh).toInt()
//        }
//        if (be <= 0)
//            be = 1

        newOpts.inSampleSize = be//设置缩放比例
//        newOpts.inPreferredConfig = Config.RGB_565//降低图片从ARGB888到RGB565
        //重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        isBm = ByteArrayInputStream(baos.toByteArray())
        bitmap = BitmapFactory.decodeStream(isBm, null, newOpts)
        return compressImage(bitmap)//压缩好比例大小后再进行质量压缩
    }

}

















