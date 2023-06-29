## 簡介

使用Spring Boot 開發的簡易後台網站。

## 環境

1. Java JDK 11
2. Spring Boot: 2.3.7.RELEASE
3. MySQL: 8.0.31
4. IntelliJ IDEA


## 技術

* 前端：React
* 後端：Java

* 框架：Spring Boot
* 資料庫：MySQL
* ORM映射：Spring Date JPA (Hibernate)
* 請求：axios

* 版控：Git、GitHub
* 測試：Postman

## API

* 帳號功能
   - 註冊新帳號
   - 登入
     
* 商品功能
   - 新增／查詢／修改／刪除商品 (CRUD)
   - 查詢商品列表


### 帳號功能

1. 註冊新帳號<br>
   `POST:   localhost:8080/users/register`

2. 登入<br>
   `POST:   localhost:8080/users/login`<br>
   request body
    ```
    {
      "email" : "Test100@gmail.com",
      "password" : "123456"
    }
    ```

### 商品功能：
1. 新增／查詢／修改／刪除商品(CRUD)

   |*method*|*url*|*description*|
   |--|--|--|
   |POST|`localhost:8080/products`|新增|
   |GET|`localhost:8080/products/{productId}`|查詢|
   |PUT|`localhost:8080/products/{productId}`|修改|
   |DELETE|`localhost:8080/products/{productId}`|刪除|

   POST & PUT request body
     ```
      {
          "productName" : "碼頭上的陌生人",
          "category" : "CHINESE",
          "imageUrl" : "[https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/068/87/0010688757.jpg&v=55e42cd7k&w=280&h=280](https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/095/05/0010950531.jpg&v=63ee05fck&w=348&h=348)",
          "price" : 300,
          "stock" : 50,
          "description" : "※特別收錄-歐大旭新撰〈自序〉獻給中文版讀者。學者熊婷惠〈那張臉、陌生人與倖存者〉專文評析"
      }
      ```





