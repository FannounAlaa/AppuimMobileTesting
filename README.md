# 📱 Mobile Calculator App Automation Testing

This project automates the testing of a basic Calculator app on Android using **Appium**, **Selenium**, and **TestNG**.

## ✅ Tools & Versions

- **Selenium:** 4.8.3  
- **TestNG:** 7.7.1  
- **Appium:** 8.3.0  
- **Android Studio** (AVD used)

## 📱 Device Setup

- Virtual device created using **Android Studio AVD Manager**
- Device name: `TestDevice`
- Device type: **Google Pixel 3a**

## 🧪 Test Cases

- Add two digits (`9 + 6 = 15`)
- Click all number buttons and take a screenshot
- Negative test: Division by zero (`8 ÷ 0`)

## ▶️ How to Run

1. Start the Appium server (`http://127.0.0.1:4723/wd/hub`)
2. Launch the `TestDevice` emulator (Pixel 3a) from Android Studio
3. Run tests via your IDE or TestNG

> Make sure the APK file is located at:  
> `src/test/java/MyApplication/calculator.apk`

## 📁 Screenshot Output

Screenshots are saved to:  
`src/test/java/ScreenShots/`

---
