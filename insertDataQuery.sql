-- Member 테이블 예시 데이터 삽입
INSERT INTO Member (member_id, member_password, member_name, member_nickname, member_age, member_gender, member_status)
VALUES
    ('user1', 'user1pass', 'User One', 'U1', 25, '남성', 1),
    ('user2', 'user2pass', 'User Two', 'U2', 30, '여성', 1),
    ('trainer1', 'trainer1pass', 'Trainer One', 'T1', 28, '남성', 2),
    ('admin', 'adminpass', 'Admin', 'Admin', NULL, NULL, 0);

-- User 테이블 예시 데이터 삽입
INSERT INTO User (member_code, prefer_part, prefer_gender, prefer_style, prefer_goal, user_readme, buy_list)
VALUES
    (1, '상체', '남성', '스트렝스', '다이어트', '운동을 즐기고 싶어요!', '피트니스 프로그램 A 구매'),
    (2, '하체', '여성', '요가', '체력 향상', '새로운 운동에 도전해보고 싶어요!', '피트니스 프로그램 B 구매');

-- Trainer 테이블 예시 데이터 삽입
INSERT INTO Trainer (member_code, provide_part, provide_style, provide_goal, video_list, trainer_readme, trainer_price, trainer_review, trainer_rating)
VALUES
    (3, '상체', '스트렝스', '다이어트', 'video1,video2,video3', '고객의 목표를 달성시키기 위해 노력합니다!', 50, '좋은 트레이너!', 4.5),
    (4, '전신', '요가', '체력 향상', 'video4,video5,video6', '다양한 운동으로 건강을 책임집니다!', 70, '최고의 트레이너!', 4.8);

-- Video 테이블 예시 데이터 삽입
INSERT INTO Video (video_title, video_readme, video_url, video_uploader)
VALUES
    ('상체 강화 프로그램', '상체 근육을 강화하는 운동 프로그램', 'https://video-url1.com', 3),
    ('요가 기초 강의', '요가의 기초 자세 및 움직임', 'https://video-url2.com', 4),
    ('다이어트 루틴', '체중 감량을 위한 다양한 운동 루틴', 'https://video-url3.com', 3);

-- Board 테이블 예시 데이터 삽입
INSERT INTO Board (member_code, board_title, board_content, board_uploader)
VALUES
    (1, '자유게시판 글', '오늘은 운동이 너무 힘들었어요 ㅠㅠ', 1),
    (2, '질문 글', '요가를 시작하려고 하는데 어떤 운동이 좋을까요?', 2);

-- Review 테이블 예시 데이터 삽입
INSERT INTO Review (member_code, review_rating, review_content)
VALUES
    (1, 5, '피트니스 프로그램 A 정말 좋아요!'),
    (2, 4, '트레이너가 친절하게 가르쳐주셔서 좋았어요!');
