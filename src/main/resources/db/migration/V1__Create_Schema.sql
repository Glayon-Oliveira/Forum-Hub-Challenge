CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT, 
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    
    PRIMARY KEY(id)    
);

CREATE TABLE profiles(
    id INT NOT NULL,
    name VARCHAR(255) NOT NULL,       
    
    PRIMARY KEY(id),
    FOREIGN KEY(id) REFERENCES users(id)
);

CREATE TABLE courses(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE,
    category VARCHAR(255) NOT NULL,
    
    PRIMARY KEY(id)
);

CREATE TABLE topics(
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    creation_date DATE NOT NULL,
    solved bit NOT NULL,
    author INT NOT NULL,
    course INT NOT NULL,
    
    PRIMARY KEY(id),
    FOREIGN KEY(author) REFERENCES users(id),
    FOREIGN KEY(course) REFERENCES courses(id)
);

CREATE TABLE responses(
    id INT NOT NULL AUTO_INCREMENT,
    message TEXT,
    topic INT NOT NULL,
    creation_date DATE NOT NULL,
    author INT NOT NULL,
    solution BIT NOT NULL,
    
    PRIMARY KEY(id),
    FOREIGN KEY(author) REFERENCES users(id),
    FOREIGN KEY(topic) REFERENCES topics(id) 
);