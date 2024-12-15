BÁO CÁO: HỆ THỐNG GỢI Ý CÔNG VIỆC VÀ ỨNG VIÊN DỰA TRÊN KỸ NĂNG
## 1. Đặt tả:
Để phát triển một hệ thống giúp quản lý và hỗ trợ quá trình tuyển dụng, có thể mô tả lại các chức năng chính như sau:
1.	Quản lý cơ sở dữ liệu các thực thể: Hệ thống sẽ lưu trữ thông tin của các thực thể như ứng viên, nhà tuyển dụng, công ty, công việc, kỹ năng, và các mối quan hệ giữa chúng (như ứng viên ứng tuyển vào công ty nào, công ty yêu cầu những kỹ năng gì, …).
2.	Gợi ý công việc phù hợp cho ứng viên: Dựa trên thông tin về kỹ năng, kinh nghiệm, vị trí mong muốn, và các tiêu chí khác của ứng viên, hệ thống sẽ phân tích và đưa ra các công việc phù hợp cho họ.
3.	Gợi ý ứng viên phù hợp cho công ty: Hệ thống sẽ gợi ý các ứng viên tiềm năng cho các công ty dựa trên yêu cầu công việc, kỹ năng và các thông tin khác từ hồ sơ ứng viên.
4.	Đề xuất kỹ năng học tập cho ứng viên: Dựa trên các kỹ năng còn thiếu trong hồ sơ của ứng viên, hệ thống sẽ đề xuất các khóa học hoặc kỹ năng cần học để giúp ứng viên cải thiện khả năng và gia tăng cơ hội tìm việc.
5.	Gửi CV từ ứng viên hoặc lời mời từ nhà tuyển dụng: Hệ thống hỗ trợ việc ứng viên gửi CV đến nhà tuyển dụng và cũng cho phép các công ty gửi lời mời làm việc tới các ứng viên phù hợp.
6.	Thống kê: Hệ thống sẽ cung cấp các báo cáo thống kê về:
o	Top kỹ năng được tuyển dụng nhiều nhất: Các kỹ năng mà các công ty yêu cầu nhiều nhất trong các công việc.
o	Top kỹ năng phổ biến của ứng viên: Các kỹ năng phổ biến trong hồ sơ của ứng viên, từ đó đánh giá nhu cầu thị trường.
o	Top công ty tuyển dụng nhiều nhất: Các công ty có nhu cầu tuyển dụng cao, giúp ứng viên dễ dàng nhận diện các nhà tuyển dụng lớn.
Hệ thống này sẽ sử dụng các thuật toán phân tích dữ liệu và các công nghệ quản lý cơ sở dữ liệu để tự động hóa các quy trình gợi ý và thống kê, giúp tối ưu hóa trải nghiệm cho cả ứng viên và nhà tuyển dụng.

## 2. Cơ sở dữ liệu lưu trữ

### CSDL: 
Hedisql là một công cụ mạnh mẽ cho phép bạn lưu trữ dữ liệu quan hệ trong Redis và thực hiện các truy vấn SQL đơn giản, giúp bạn dễ dàng quản lý các thực thể trong hệ thống tuyển dụng.
![markdown](https://github.com/tienminhtran/LT_WWW/blob/main/week5_springboot_jobseeking/data/sql.png)
### Cấu trúc các bảng và mối quan hệ:
-	**Candidate** (Ứng viên): Lưu trữ thông tin về ứng viên.
-	**CandidateSkill** (Kỹ năng của ứng viên): Lưu trữ thông tin về kỹ năng mà ứng viên sở hữu.
-	**CandidateSkillID** (ID kỹ năng của ứng viên): Mối quan hệ giữa ứng viên và kỹ năng của họ.
-	**Company** (Công ty): Lưu trữ thông tin về công ty.
-	**Experience** (Kinh nghiệm): Lưu trữ thông tin về kinh nghiệm làm việc của ứng viên.
-	**Job** (Công việc): Lưu trữ thông tin về công việc cần tuyển dụng.
-	**JobSkill** (Kỹ năng công việc): Lưu trữ các kỹ năng cần có cho công việc.
-	**JobSkillID** (ID kỹ năng công việc): Mối quan hệ giữa công việc và kỹ năng cần có.
-	**Skill** (Kỹ năng): Lưu trữ thông tin về các kỹ năng mà ứng viên và công ty có thể yêu cầu.

## 3. Thực hiện

### Repositories Interface:

-	**AddressRepository** là một lớp giúp quản lý các thao tác cơ bản với dữ liệu liên quan đến địa chỉ (Address) trong cơ sở dữ liệu bằng cách sử dụng các phương thức có sẵn của JpaRepository
-	**CandidateRepository** giúp quản lý và truy vấn các thông tin liên quan đến ứng viên (Candidate) trong cơ sở dữ liệu, bao gồm các chức năng tìm kiếm, kiểm tra tính hợp lệ của dữ liệu, và thực hiện các truy vấn tùy chỉnh như tìm kiếm theo kỹ năng. CRUD cơ bản: Với việc kế thừa từ JpaRepository, bạn có thể sử dụng các phương thức có sẵn như save(), findById(), findAll(), deleteById()
-	**CandidateSkillRepository** giúp quản lý và tìm kiếm thông tin về kỹ năng của ứng viên. Các phương thức này hỗ trợ việc lấy dữ liệu theo nhiều tiêu chí như ID của ứng viên và kỹ năng, cũng như thống kê các kỹ năng phổ biến trong cộng đồng ứng viên.
-	**CompanyRepository** hỗ trợ việc tìm kiếm và kiểm tra tính hợp lệ của thông tin công ty trong hệ thống. Các phương thức này đảm bảo rằng email và số điện thoại của công ty không bị trùng lặp khi thêm hoặc cập nhật dữ liệu.
-	**ExperienceRepository** giúp thực hiện các thao tác cơ bản trên dữ liệu kinh nghiệm của ứng viên trong hệ thống mà không cần phải viết mã SQL thủ công.
-	**JobRepository** cung cấp các phương thức mạnh mẽ để tìm kiếm công việc dựa trên nhiều yếu tố như email công ty, kỹ năng của ứng viên, tên công việc, và tên công ty. Việc sử dụng truy vấn tùy chỉnh giúp linh hoạt hơn trong việc tìm kiếm các công việc phù hợp
-	**JobSkillRepository** cung cấp các phương thức hữu ích để truy vấn các kỹ năng yêu cầu cho từng công việc và phân tích các kỹ năng phổ biến nhất trong thị trường việc làm.
-	**SkillRepository** cung cấp các phương thức quan trọng để tìm kiếm các kỹ năng mà ứng viên chưa có, giúp đưa ra các gợi ý kỹ năng cần học thêm. Phương thức findBySkillName hỗ trợ tìm kiếm kỹ năng cụ thể, đáp ứng nhu cầu truy vấn theo tên kỹ năng. Những phương thức này rất hữu ích trong việc hỗ trợ các ứng viên phát triển kỹ năng của mình hoặc giúp các nhà tuyển dụng tìm kiếm các kỹ năng phù hợp.

### Lớp Services

-	**CandidateServicecung** cấp chức năng toàn diện để quản lý ứng viên, bao gồm tạo, cập nhật và truy xuất ứng viên dựa trên nhiều tiêu chí khác nhau. Trong khi nó xử lý các mối quan hệ phức tạp giữa ứng viên, kỹ năng và kinh nghiệm, vẫn có chỗ để tối ưu hóa về hiệu suất, xử lý lỗi và ghi nhật ký.
-	**CompanyService** cung cấp các chức năng cơ bản để quản lý thông tin công ty trong ứng dụng Spring Boot. Các phương thức chính của lớp này bao gồm tìm công ty theo ID hoặc email, kiểm tra sự tồn tại của công ty dựa trên email hoặc số điện thoại, và lưu thông tin công ty và địa chỉ của công ty
-	**EmailService** thực hiện chức năng gửi email
-	**JobApplicationService** này thực hiện việc gửi email thông báo ứng tuyển cho các nhà tuyển dụng sau khi một ứng viên gửi đơn ứng tuyển cho công việc.
-	**JobService** đã thực hiện rất tốt các chức năng quản lý công việc như tìm kiếm, phân trang, lưu, xóa và gợi ý công việc.
-	**JobSkillService** có cấu trúc rất đơn giản và rõ ràng với các phương thức như save để lưu thông tin kỹ năng công việc và findByJob để tìm các kỹ năng của một công việc cụ thể.
-	****SkillService** này quản lý các thao tác liên quan đến kỹ năng trong hệ thống. Nó bao gồm các phương thức để tìm kiếm, lưu trữ và đề xuất kỹ năng cho ứng viên. Lớp này hoạt động với **SkillRepository**, sử dụng các tính năng của Spring Data JPA
-	**StatsService** cung cấp các chức năng thống kê về kỹ năng, sử dụng các câu truy vấn và xử lý kết quả rất hợp lý.

## 4. Giao diện

### Giao diện ứng viên:

> ![minhchung](https://github.com/tienminhtran/LT_WWW/blob/main/week5_springboot_jobseeking/2024-12-15-23-14-23.gif)

### Giao diện check mail gởi từ ứng viên:

> ![minhchung](https://github.com/tienminhtran/LT_WWW/blob/main/week5_springboot_jobseeking/2024-12-15-23-19-45.gif)

### Giao diện từ ứng viên , tìm kiếm , chỉnh sửa, thống kê:

> ![minhchung](https://github.com/tienminhtran/LT_WWW/blob/main/week5_springboot_jobseeking/2024-12-15-23-20-32.gif)


### Giao diện phía Nhà tuyển dụng:

> ![minhchung](https://github.com/tienminhtran/LT_WWW/blob/main/week5_springboot_jobseeking/2024-12-15-23-28-36.gif)


### Giao diện check mail gởi từ   Nhà tuyển dụng:

> ![minhchung](https://github.com/tienminhtran/LT_WWW/blob/main/week5_springboot_jobseeking/2024-12-15-23-33-25.gif)
