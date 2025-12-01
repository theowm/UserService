INSERT INTO users (uuid, name, username) VALUES
('57b038ed-fb36-4b39-8748-5fafe89bf2b0', 'John Doe', 'john'),
('d4733399-2251-4ba2-8bab-3035fe884edc', 'Jane Smith', 'jane');

INSERT INTO likes (uuid, user_uuid, media_uuid, media_type) VALUES
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', '57b038ed-fb36-4b39-8748-5fafe89bf2b0', '99999999-9999-9999-9999-999999999999', 'MUSIC'),
('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', 'd4733399-2251-4ba2-8bab-3035fe884edc', '88888888-8888-8888-8888-888888888888', 'VIDEO');

INSERT INTO dislikes (uuid, user_uuid, media_uuid, media_type) VALUES
('cccccccc-cccc-cccc-cccc-cccccccccccc', '57b038ed-fb36-4b39-8748-5fafe89bf2b0', '77777777-7777-7777-7777-777777777777', 'PODCAST');