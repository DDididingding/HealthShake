INSERT INTO Member (member_id, member_password, member_name, member_nickname, member_age, member_gender, member_profile_pic, member_status) 
VALUES 
('u1', 'u1', '김현지', '유저1김현지', 25, 'female', '/images/user1.jpg', 1),
('u2', 'u2', '안준현', '유저2안준현', 30, 'male', '/images/user2.jpg', 1),
('u3', 'u3', '최연준', '유저3최연준', 25, 'female', '/images/user3.jpg', 1),
('u4', 'u4', '이지우', '유저4이지우', 30, 'female', '/images/user4.jpg', 1),
('u5', 'u5',  '강수아', '유저5강수아', 30, 'female', '/images/user5.jpg', 1),
('u6', 'u6', '정소영', '유저6정소영', 30, 'female', '/images/user6.jpg', 1),
('t1', 't1', '김피티', '트레이너1김피티', 28, 'male', '/images/trainer1.jpg', 2),
('t2', 't2', '이피티', '트레이너2이피티', 30, 'female', '/images/trainer2.jpg', 2),
('t3', 't3', '최피티', '트레이너3최피티', 35, 'male', '/images/trainer3.jpg', 2),
('t4', 't4', '김운동', '트레이너4김운동', 27, 'female', '/images/trainer4.jpg', 2),
('t5', 't5', '이운동', '트레이너5이운동', 21, 'male', '/images/trainer5.jpg', 2),
('t6', 't6', '최운동', '트레이너6최운동', 21, 'female', '/images/trainer6.jpg', 2),
('admin', 'adminpass', 'Admin', 'Admin', NULL, NULL, 'profile_pic4.jpg', 0);


-- User 테이블에 대한 샘플 데이터
INSERT INTO User (member_code, prefer_part, prefer_gender, prefer_style, prefer_goal, user_readme) 
VALUES 
(1, '상체', '남성', '힘 단련', '근육 증가', '피트니스를 사랑합니다!'),
(2, '하체', '여성', '유산소', '체중 감량', '피트니스 열악자!'),
(3, '하체', '남성', '스트렝스', '체력 향상', '운동으로 건강을 유지하고 싶어요!'),
(4, '상체', '여성', '필라테스', '체중 감량', '스트레스를 풀고 싶어요!'),
(5, '코어', '남성', '크로스핏', '근력 강화', '목표 달성을 위해 노력하겠습니다!'),
(6, '전신', '여성', '댄스', '건강한 라이프스타일', '새로운 운동으로 즐거운 시간을 보내고 싶어요!');


-- Trainer 테이블에 대한 샘플 데이터
INSERT INTO Trainer (member_code, provide_part, provide_style, provide_goal, trainer_readme) 
VALUES 
(7, '전신', '기능성 트레이닝', '체중 감량', '경험 많은 트레이너!'),
(8, '코어', 'HIIT', '근육 토닝', '피트니스에 열정적인 트레이너!'),
(9, '하체', '필라테스', '체력 향상', '체계적인 트레이닝을 제공하는 전문가입니다!'),
(10, '상체', '웨이트 트레이닝', '근육 강화', '맞춤형 운동 프로그램으로 최선을 다하는 트레이너입니다!'),
(11, '코어', '요가', '스트레칭', '유연성을 높여주는 효과적인 운동을 제공하는 트레이너입니다!'),
(12, '상체', '카디오', '체중 감량', '다양한 유산소 운동으로 건강한 몸을 만들어드립니다!');

-- Video 테이블에 대한 샘플 데이터
INSERT INTO Video (video_title, video_readme, video_url, video_uploader) 
VALUES 
('복부 운동', '뱃살 아랫뱃살 최고의 운동', 'https://www.youtube.com/watch?v=0L5gAT1fJaM&t=1s', 7),
('복부 운동', '무.조.건! 뱃살 빠지는 운동 베스트5', 'https://www.youtube.com/watch?v=iOSYLKBk894', 7),
('복부 운동', '11자복근 복부 최고의 운동 [복근 핵매운맛]', 'https://www.youtube.com/watch?v=PjGcOP-TQPE', 7),
('복부 운동', '[ENG] (층간소음X, 설명O) 복근운동과 유산소를 한번에❗️서서하는 복근운동 1탄🔥', 'https://www.youtube.com/watch?v=kETh8T3it4k&t=1s', 8),
('전신 운동', '[ENG] 🔥효과 200% 보장🔥 힙으뜸 덤벨 운동 올인원루틴💪🏼💪🏼슬림탄탄! 가보자고~~', 'https://www.youtube.com/watch?v=ojWHzxUzEVk', 8),
('전신 운동', '[ENG] 🚨폭식 후 운동🚨 뱃살로 가기 전에 움직여!!!!! 힙으뜸 전신운동 20분 올인원루틴✊🏼', 'https://www.youtube.com/watch?v=Ueb365f-bY0', 8),
('유산소 운동', '가볍지만 확실하게 체지방 걷어내는 유산소 / 다이어트 운동 홈트레이닝 - 논스탑 휴식없음', 'https://www.youtube.com/watch?v=yJm9SGS2IhA&t=1s', 9),
('유산소 운동', '할로윈 파티 대신 우리는 홈트 한다 👻 10분 논스톱 근력 유산소', 'https://www.youtube.com/watch?v=vRTymm71tPo&t=1s', 9),
('유산소 운동', '새해 시작은 덤벨 - 체지방 빼며 근육 잡는 20분 전신 덤벨 근력 유산소 홈트 운동', 'https://www.youtube.com/watch?v=wPF-l9gt-hw', 9),
('하체 운동', '이거하면 ‘톡 튀어나온 허벅지 안쪽 맨 윗살’이 🔥무조건🔥 빠져요! (+허벅지 사이가 일자로 똑 떨어지는 7일 루틴)', 'https://www.youtube.com/watch?v=3neRUAR5r1c', 10),
('스트레칭', '몸이 붓고 답답하다면, 전신 노폐물 쫙 빼주는 12분 폼롤러 마사지🏝', 'https://www.youtube.com/watch?v=CXL0RgtXoJE', 10),
('전신 운동', '상체살 빼는 효과최강 루틴만 모았습니다🔥 (뱃살/등살/팔뚝살/승모근 올케어 루틴)', 'https://www.youtube.com/watch?v=-Rbf1gGWrLk', 10),
('유산소 운동', '살이 너무 빠지는 죽음의 타바타 운동 (no 층간소음) / Beautiful tabata workout', 'https://www.youtube.com/watch?v=4EKo44DUvjg', 11),
('유산소 운동', '르세라핌이 실제로 했던 18분 다이어트 운동 ( * 살 빨리 빼고 싶다면 이 루틴 꼭 해보세요. 효과 대박입니다. )', 'https://www.youtube.com/watch?v=7GNK3G6JT0w', 11),
('팔 운동', '💪🏻정말 안빠지는 두툼한 팔뚝살 🔥1달만에 -7cm 없애는🔥 효과 보장 루틴 ( * 하루에 딱 8분만 투자하세요 )', 'https://www.youtube.com/watch?v=N1ZpbAWvRpw', 11),
('다이어트 댄스', '🔥살 빠지는 칼로리 폭파 다이어트 댄스🔥 뉴진스 - SUPER SHY💕 슈퍼샤이 다이어트 댄스', 'https://www.youtube.com/watch?v=Ldkx9anl588', 12),
('복부 운동', '카즈하님…솔직히 이렇게 운동하는 건 반칙이죠…ㅠㅜ [역대급 6분 뱃살 파괴 운동]', 'https://www.youtube.com/watch?v=kj2Cx3QlVCQ', 12),
('전신 운동', '와...르세라핌이 ‘이 동작’으로 살을 뺐구나....[극강의 9분 전신운동]', 'https://www.youtube.com/watch?v=N7W4mvOyxIk', 12);


-- BuyList 테이블에 대한 샘플 데이터
INSERT INTO BuyList (user_member_code, trainer_member_code) 
VALUES 
(1, 7),
(1, 8),
(2, 10),
(3, 7),
(3, 8),
(3, 12),
(4, 9),
(4, 12),
(5, 9),
(5, 7),
(5, 11),
(6, 7),
(6, 8),
(6, 12);

-- Review 테이블에 대한 샘플 데이터
INSERT INTO Review (member_code, review_rating, review_content, review_writer) 
VALUES 
(7, 4, '좋은 프로그램입니다!', 1),
(7, 5, '트레이너님 최고!', 3),
(7, 4, '좋은 프로그램입니다!', 5),
(7, 5, '트레이너님 최고!',  6),
(8, 4, '정말 유용한 정보가 많았어요!', 1),
(8, 3, '좀 더 다양한 컨텐츠가 있었으면 좋겠어요.',3),
(8, 5, '완벽한 트레이너와 프로그램이었습니다!', 6),
(9, 4, '일상에 필요한 유익한 정보를 얻을 수 있었어요.', 4),
(9, 5, '트레이너님의 도움으로 목표를 달성했습니다!', 5),
(10, 3, '내용이 좀 어려웠지만 유익했어요.', 2),
(11, 5, '매우 만족스러운 트레이닝이었습니다.', 5),
(12, 4, '정보가 유용해서 좋았습니다!', 3),
(12, 5, '최고의 트레이너와 함께한 시간이었습니다!', 4);

-- Board 테이블에 대한 샘플 데이터
INSERT INTO Board (member_code, board_title, board_content, board_uploader) 
VALUES 
(7, '운동 팁 공유', '오늘은 효과적인 운동 방법에 대해 알려드립니다.', 1),
(7, '다이어트 일지', '체중 감량을 위한 나만의 다이어트 일지입니다.', 5),
(8, '근육 키우는 방법', '근육을 키우기 위한 유용한 정보를 공유합니다.', 8),
(8, '스트레칭의 중요성', '스트레칭이 몸에 미치는 긍정적인 영향에 대해 알아봅시다.', 3),
(9, '다이어트 식단 공유', '건강한 다이어트 식단에 대해 이야기해요!', 4),
(9, '헬스장에서의 첫날', '헬스장 입문자들을 위한 팁을 공유합니다.', 9),
(10, '운동의 재미를 찾아서', '운동을 즐기는 방법에 대해 이야기해봐요!', 2),
(10, '스트레스와 운동', '스트레스 해소를 위한 운동 방법에 대해 알아봅시다.', 10),
(11, '헬스장에서의 목표', '헬스장에서의 목표 설정 방법을 공유해요!', 5),
(11, '다이어트의 시작', '다이어트를 시작하는 사람들을 위한 조언입니다.', 11),
(12, '운동하는 여자들', '여성들을 위한 운동 팁과 정보를 나눠봐요!', 6),
(12, '근력 향상을 위한 방법', '근력을 키우기 위한 방법을 공유해요!', 3);