-- Member 테이블 예시 데이터 삽입
INSERT INTO Member (member_id, member_password, member_name, member_nickname, member_age, member_gender, member_profile_pic ,member_status)
VALUES
    ('user1', 'user1pass', 'User One', 'U1', 25, '남성', 'profile_pic1.jpg', 1),
    ('user2', 'user2pass', 'User Two', 'U2', 30, '여성', 'profile_pic2.jpg', 1),
    ('trainer1', 'trainer1pass', 'Trainer One', 'T1', 28, '남성', 'profile_pic3.jpg', 2),
    ('admin', 'adminpass', 'Admin', 'Admin', NULL, NULL, 'profile_pic4.jpg', 0),
    ('trainer2', 'trainer2pass', 'Trainer Two', 'T1', 28, '남성', 'profile_pic5.jpg' ,2);

-- User 테이블 예시 데이터 	삽입
INSERT INTO User (member_code, prefer_part, prefer_gender, prefer_style, prefer_goal, user_readme, buy_list)
VALUES
    (1, '상체', '남성', '스트렝스', '다이어트', '운동을 즐기고 싶어요!', '피트니스 프로그램 A 구매'),
    (2, '하체', '여성', '요가', '체력 향상', '새로운 운동에 도전해보고 싶어요!', '피트니스 프로그램 B 구매');

-- Trainer 테이블 예시 데이터 삽입
INSERT INTO Trainer (member_code, provide_part, provide_style, provide_goal, video_list, trainer_readme, trainer_price, trainer_review, trainer_rating)
VALUES
    (3, '상체', '스트렝스', '다이어트', 'video1,video2,video3', '고객의 목표를 달성시키기 위해 노력합니다!', 50, '좋은 트레이너!', 4.5),
    (5, '전신', '요가', '체력 향상', 'video4,video5,video6', '다양한 운동으로 건강을 책임집니다!', 70, '최고의 트레이너!', 4.8);

-- Video 테이블 예시 데이터 삽입
INSERT INTO Video (video_title, video_readme, video_url, video_uploader)
VALUES
    ('상체 강화 프로그램', '상체 근육을 강화하는 운동 프로그램', 'https://video-url1.com', 3),
    ('요가 기초 강의', '요가의 기초 자세 및 움직임', 'https://video-url2.com', 5),
    ('다이어트 루틴', '체중 감량을 위한 다양한 운동 루틴', 'https://video-url3.com', 3);

-- Board 테이블 예시 데이터 삽입
INSERT INTO Board (member_code, board_title, board_content, board_uploader)
VALUES
    (1, '자유게시판 글', '오늘은 운동이 너무 힘들었어요 ㅠㅠ', 1),
    (2, '질문 글', '요가를 시작하려고 하는데 어떤 운동이 좋을까요?', 2);

-- Review 테이블 예시 데이터 삽입
INSERT INTO Review (member_code, review_writer,review_rating, review_content)
VALUES
    (3, 1, 4.3, '피트니스 프로그램 A 정말 좋아요!'),
    (5, 2, 4.2, '트레이너가 친절하게 가르쳐주셔서 좋았어요!');
  
  
 -- 유저 더미 데이터 삽입
INSERT INTO Member (member_id, member_password, member_name, member_nickname, member_age, member_gender, member_status)
VALUES
  ('user11', 'password1', 'User 1', 'Nickname1', 25, 'Male', 1),
  ('user12', 'password2', 'User 2', 'Nickname2', 28, 'Female', 1),
  ('user13', 'password3', 'User 3', 'Nickname3', 22, 'Male', 1),
  ('user14', 'password4', 'User 4', 'Nickname4', 30, 'Female', 1),
  ('user15', 'password5', 'User 5', 'Nickname5', 26, 'Male', 1);

-- 트레이너 더미 데이터 삽입
INSERT INTO Member (member_id, member_password, member_name, member_nickname, member_age, member_gender, member_status)
VALUES
  ('trainer11', 'password1', 'Trainer 1', 'T-Nickname1', 35, 'Male', 2),
  ('trainer12', 'password2', 'Trainer 2', 'T-Nickname2', 32, 'Female', 2),
  ('trainer13', 'password3', 'Trainer 3', 'T-Nickname3', 29, 'Male', 2),
  ('trainer14', 'password4', 'Trainer 4', 'T-Nickname4', 27, 'Female', 2),
  ('trainer15', 'password5', 'Trainer 5', 'T-Nickname5', 33, 'Male', 2); 
    
    
    -- 나머지 User 더미 데이터 삽입
INSERT INTO User (member_code, prefer_part, prefer_gender, prefer_style, prefer_goal, user_readme, buy_list)
VALUES
    (6, '하체', '남성', '스트렝스', '다이어트', '운동을 즐기고 싶어요!', '피트니스 프로그램 C 구매'),
    (7, '상체', '여성', '요가', '체력 향상', '새로운 운동에 도전해보고 싶어요!', '피트니스 프로그램 D 구매'),
    (8, '전신', '남성', '헬스', '근육 증가', '다양한 헬스 프로그램을 경험하고 싶어요!', '피트니스 프로그램 E 구매'),
    (9, '하체', '여성', '스트렝스', '체력 향상', '스트렝스 운동에 관심이 있어요!', '피트니스 프로그램 F 구매'),
    (10, '상체', '남성', '요가', '다이어트', '요가로 몸을 가볍게 만들어요!', '피트니스 프로그램 G 구매');

-- 나머지 Trainer 더미 데이터 삽입
INSERT INTO Trainer (member_code, provide_part, provide_style, provide_goal, video_list, trainer_readme, trainer_price, trainer_review, trainer_rating)
VALUES
    (11, '하체', '스트렝스', '다이어트', 'video7,video8,video9', '고객의 목표를 달성시키기 위해 노력합니다!', 60, '매우 성실한 트레이너!', 4.7),
    (12, '상체', '요가', '체력 향상', 'video10,video11,video12', '다양한 운동으로 건강을 책임집니다!', 80, '최고의 트레이너!', 4.9),
    (13, '전신', '스트렝스', '근육 증가', 'video13,video14,video15', '고객의 목표에 맞춘 트레이닝을 제공합니다!', 70, '정말 친절한 트레이너!', 4.6),
    (14, '하체', '요가', '체력 향상', 'video16,video17,video18', '체력 향상을 위한 다양한 운동을 가르칩니다!', 90, '매우 만족스러운 트레이너!', 4.9),
    (15, '상체', '스트렝스', '다이어트', 'video19,video20,video21', '다양한 운동으로 목표를 달성하는데 도움을 드립니다!', 75, '좋은 트레이너!', 4.8);

INSERT INTO Board (member_code, board_title, board_content, board_uploader)
VALUES
    (3, '운동 팁 공유', '오늘은 유산소 운동이 효과적이었어요!', 3),
    (4, '트레이너 소개', '안녕하세요! Trainer One입니다. 함께 목표를 달성해봐요!', 3),
    (5, '체력 향상에 도움되는 음식', '운동 전후에 섭취하기 좋은 음식 추천해주세요!', 3),
    (5, '다이어트 일지', '오늘부터 다이어트를 시작합니다. 같이 응원해주세요!', 6),
    (5, '헬스장 추천', '지역별로 좋은 헬스장이 있을까요? 추천 부탁드려요!', 7);
