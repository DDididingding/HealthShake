-- Member 테이블에 대한 샘플 데이터
INSERT INTO Member (member_id, member_password, member_name, member_nickname, member_age, member_gender, member_profile_pic, member_status) 
VALUES 
('u', 'u', '사용자 1', 'U1', 25, '남성', 'profile1.jpg', 1),
('user2@example.com', 'user456', '사용자 2', 'U2', 30, '여성', 'profile2.jpg', 1),
('t', 't', '트레이너 1', 'T1', 28, '남성', 'profile3.jpg', 2),
('trainer2@example.com', 'trainer456', '트레이너 2', 'T2', 35, '여성', 'profile4.jpg', 2),
('admin@example.com', 'admin123', '관리자', '관리자', NULL, NULL, NULL, 3);

-- User 테이블에 대한 샘플 데이터
INSERT INTO User (member_code, prefer_part, prefer_gender, prefer_style, prefer_goal, user_readme, buy_list) 
VALUES 
(1, '상체', '남성', '힘 단련', '근육 증가', '피트니스를 사랑합니다!', NULL),
(2, '하체', '여성', '유산소', '체중 감량', '피트니스 열악자!', NULL);

-- Trainer 테이블에 대한 샘플 데이터
INSERT INTO Trainer (member_code, provide_part, provide_style, provide_goal, video_list, trainer_readme, trainer_price, trainer_review, trainer_rating) 
VALUES 
(3, '전신', '기능성 트레이닝', '체중 감량', NULL, '경험 많은 트레이너!', 50, '훌륭한 트레이너!', 4.8),
(4, '코어', 'HIIT', '근육 토닝', NULL, '피트니스에 열정적인 트레이너!', 60, '우수한 트레이너!', 4.9);

-- Video 테이블에 대한 샘플 데이터
INSERT INTO Video (video_title, video_readme, video_url, video_uploader) 
VALUES 
('전신 운동', '전신에 대한 완벽한 운동 루틴.', 'video1.mp4', 3),
('코어 강화', '강력한 코어를 위한 운동에 중점을 둡니다.', 'video2.mp4', 3),
('카디오 블라스트', '고강도의 유산소 운동.', 'video3.mp4', 4),
('다리 운동 루틴', '하체를 위한 효과적인 운동.', 'video4.mp4', 4),
('기능성 트레이닝', '기능성 운동으로 전체적인 피트니스 향상.', 'video5.mp4', 4);

-- BuyList 테이블에 대한 샘플 데이터
INSERT INTO BuyList (user_code, video_code) 
VALUES 
(1, 3),
(2, 4);

-- Review 테이블에 대한 샘플 데이터
INSERT INTO Review (member_code, review_rating, review_content, review_uploadtime, review_like, review_dislike, review_writer) 
VALUES 
(1, 4, '좋은 프로그램입니다!', '2023-01-15 10:30:00', 15, 2, 2),
(2, 5, '트레이너님 최고!', '2023-02-20 14:45:00', 25, 1, 3);

-- Board 테이블에 대한 샘플 데이터
INSERT INTO Board (member_code, board_title, board_content, board_uploader, board_viewcnt, board_uploadtime, board_modify_status) 
VALUES 
(3, '운동 팁 공유', '오늘은 효과적인 운동 방법에 대해 알려드립니다.', 1, 120, '2023-03-05 09:15:00', 1),
(4, '다이어트 일지', '체중 감량을 위한 나만의 다이어트 일지입니다.', 2, 85, '2023-03-10 12:20:00', 0);

