DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS column;
DROP TABLE IF EXISTS card;

CREATE TABLE user (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL
);

INSERT INTO user (first_name, last_name) VALUES
('Anu', 'Sahu'),
('Amit', 'Kumar'),
('Neha', 'Sharma');

CREATE TABLE board (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    board_name VARCHAR(250) NOT NULL,
    created_by VARCHAR(250) NOT NULL
);

CREATE TABLE column (
       id INT AUTO_INCREMENT  PRIMARY KEY,
       column_name VARCHAR(250) NOT NULL,
       board_id INT,
       FOREIGN KEY (board_id) references board(id)
);

CREATE TABLE card (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    card_name VARCHAR(250) NOT NULL,
    card_level VARCHAR(250) NOT NULL,
    tag VARCHAR(250) NOT NULL,
    highlighted BOOLEAN,
    timestamp VARCHAR(250) NOT NULL,
    assign_to INT,
    column_id INT,
    FOREIGN KEY (column_id) references column(id),
    FOREIGN KEY (assign_to) references user(id)
);


INSERT INTO board (board_name, created_by) VALUES
('board1', 'Anu'),
('board2', 'Amit'),
('board3', 'Neha');

INSERT INTO column (column_name, board_id) VALUES
('todo', 1),
('done', 1);

INSERT INTO card (card_name, card_level, tag, highlighted, timestamp, assign_to, column_id) VALUES
('card1', 'level1','tag1', true, '30-05-2021T10:16:21', 1, 1),
('card2', 'level2','tag2', true, '30-05-2021T10:16:21', 1, 1),
('card3', 'level3','tag1', true, '30-05-2021T10:16:21', 2, 1);