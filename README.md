## ❤️M2Dia Android Dialog Tool
<div align="center">
    <img src="https://pan.losfer.cn/view.php/911f908b42b9c15bfcf1543cb45f33d8.png">
</div>

## 🤡Configuration
Context, title, and type must be assigned, and other parameters can be customized and implemented. Place this anywhere in your app:
```java
m2Dia = M2Dia.createSuccess(MainActivity.this, getString(R.string.success_title), M2Dia.M2ButTpe.HAVE_ALL_BUT)
             .setContent(getString(R.string.context)) // set the context , default null
             .setConfirmClick(con) // confirm button click , default dismiss
             .setCloseClick(clo) // close button click , default dismiss
             .setConfirmButText("confirm T") // confirm button text , default "confirm"
             .setCloseButText("close T") // close button text , default "close"
             .setLottieJson(M2Dia.M2Type.SUCCESS, "success.json") // custom lottie , default success.json
             .setRepeatCount(5) // lottie count ,if 0 then only play 1 , default 0
             .setCancelables(false) // Allow closing by clicking the return button , default true
             .setCanceledOnTouchOutsides(false) // Allow closing by clicking on the screen , default true
             .showM2(); // show the dialog
```
When you want to close it, you can define an M2Dia class variable and implement the following methods:
```java
private M2Dia m2Dia; //import
...
m2Dia = M2Dia.createError(MainActivity.this, getString(R.string.error_title), M2Dia.M2ButTpe.NO_CLOSE_BUT)
             .showM2(); //create
...
m2Dia.dismiss(); //dismiss
```

## 🐳Usage
Each method always returns a `Toast` object, so you can customize the Toast much more. **DON'T FORGET THE `show()` METHOD!**
Have confirm and close button:
```java
M2Dia.createWarning(MainActivity.this, getString(R.string.warning_title), M2Dia.M2ButTpe.HAVE_ALL_BUT)
     .showM2();
```
Have confirm button ,no have close button:
```java
M2Dia.createError(MainActivity.this, getString(R.string.error_title), M2Dia.M2ButTpe.NO_CLOSE_BUT)
     .showM2();
```

## 🤢Email
#### Hi there 👋,I'm Evan.
- 🔭 I’m currently working on something cool.
- 🌱 I’m currently learning Everything I like.
- 💬 Ask me about anything related to Java/Python.
- 📫 How to reach me: uyevan@163.com
- 😄 Read more about my Blog: [GoTo](https://jfkj.xyz)

## 🏁Screenshots
##### gif
![c5b96a847e28db5356a4296bf54ca8ec](https://user-images.githubusercontent.com/92195051/230720555-a627107e-3091-408a-b02a-9b505c10558b.gif)
##### img
<img title="" src="https://pan.losfer.cn/view.php/a649e8418926da7df8e957703e369afa.jpg" alt="" width="221" data-align="center">
<img title="" src="https://pan.losfer.cn/view.php/1e657818d594831f94722e6f442cb3d2.jpg" alt="" width="221" data-align="center">
<img title="" src="https://pan.losfer.cn/view.php/d46b2866c9c52f02cf8e29d23629f41f.jpg" alt="" width="221" data-align="center">
