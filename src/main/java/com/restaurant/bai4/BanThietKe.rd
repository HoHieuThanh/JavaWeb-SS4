URL: /bai4/products?category=chay&limit=10
-> category, limit (RequestParam)

Controller: Nhận dữ liệu
-> đẩy vào ModelMap với key: category, limit, message

View (JSP): File: productList.jsp
-> Hiển thị dữ liệu bằng ${category}, ${limit}, ${message