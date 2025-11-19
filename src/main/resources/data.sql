
INSERT INTO users (uuid, name, username) VALUES ('11111111-1111-1111-1111-111111111111', 'John Doe', 'john'),('22222222-2222-2222-2222-222222222222', 'Jane Smith', 'jane');


INSERT INTO likes (uuid, user_uuid, media_uuid) VALUES ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', '11111111-1111-1111-1111-111111111111', '99999999-9999-9999-9999-999999999999'),('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', '22222222-2222-2222-2222-222222222222', '88888888-8888-8888-8888-888888888888');


INSERT INTO dislikes (uuid, user_uuid, media_uuid) VALUES ('cccccccc-cccc-cccc-cccc-cccccccccccc', '11111111-1111-1111-1111-111111111111', '77777777-7777-7777-7777-777777777777');