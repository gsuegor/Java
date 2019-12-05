INSERT INTO lab12.user (user_id, password, username) VALUES (1, '$2a$08$LQ778VLZHRSq5TgzkIRuYeDtkRht1PFh4tAozHAyDBZ/U93siKr3G', 'user');
INSERT INTO lab12.user (user_id, password, username) VALUES (2, '$2a$08$LQ778VLZHRSq5TgzkIRuYeDtkRht1PFh4tAozHAyDBZ/U93siKr3G', 'admin');
INSERT INTO lab12.user (user_id, password, username) VALUES (3, '$2a$08$LQ778VLZHRSq5TgzkIRuYeDtkRht1PFh4tAozHAyDBZ/U93siKr3G', 'egor');

INSERT INTO lab12.certificate (certificate_id, description, issued_by, title) VALUES (1, 'some important certificate 1', 'gsu', 'big react developer');
INSERT INTO lab12.certificate (certificate_id, description, issued_by, title) VALUES (2, 'some important certificate 2', 'epam', 'big angular developer');
INSERT INTO lab12.certificate (certificate_id, description, issued_by, title) VALUES (3, 'some important certificate 3', 'iba', 'super big spring developer');

INSERT INTO lab12.users_certificates (user_id, certificate_id) VALUES (1, 1);
INSERT INTO lab12.users_certificates (user_id, certificate_id) VALUES (2, 1);
INSERT INTO lab12.users_certificates (user_id, certificate_id) VALUES (1, 2);
INSERT INTO lab12.users_certificates (user_id, certificate_id) VALUES (2, 2);
INSERT INTO lab12.users_certificates (user_id, certificate_id) VALUES (3, 3);