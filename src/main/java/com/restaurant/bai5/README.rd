1. Data flow
Client → Controller → Service → Repository → Database

2. Bẫy dữ liệu ép kiểu
Khi người dùng nhập ID không phải số (ví dụ: "abc"), hệ thống sẽ không thể ép kiểu sang Long và gây ra lỗi. Để tránh crash hệ thống, ta dùng try-catch để bắt lỗi NumberFormatException và trả về thông báo. Điều này giúp cải thiện trải nghiệm người dùng và đảm bảo hệ thống ổn định.

3. Idempotent
Phương thức DELETE là idempotent vì dù gọi nhiều lần, kết quả cuối cùng vẫn giống nhau (đơn hàng đã bị xóa). Ngược lại, POST không idempotent vì mỗi lần gọi sẽ tạo ra một đơn hàng mới, dẫn đến dữ liệu bị trùng lặp nếu người dùng bấm nhiều lần.