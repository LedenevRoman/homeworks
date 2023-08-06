Создать коллекцию users и заполнить документами со следующими свойствами: id, firstname, lastname, age, gender. Используйте следующие данные:
1 Анатолий Ушанов 28 m
2 Светлана Демидова 25 f
3 Никита Иванов 33 m
4 Ольга Петрова 22 f

db.createCollection("users")
db.users.insertMany([
    {
        id: 1,
        firstname: "Анатолий",
        lastname: "Ушанов",
        age: 28,
        gender: 'm'
    },
    {
        id: 2,
        firstname: "Светлана",
        lastname: "Демидова",
        age: 25,
        gender: 'f'
    },
    {
        id: 3,
        firstname: "Никита",
        lastname: "Иванов",
        age: 33,
        gender: 'm'
    },
    {
        id: 4,
        firstname: "Ольга",
        lastname: "Петрова",
        age: 22,
        gender: 'f'
    }
])

Создать коллекцию workers и заполнить документами со следующими свойствами: id, firstname, lastname, position, salary. Используйте следующие данные:
1 Петр Сергеев CEO 7000
2 Виктор Семенов Web-developer 5000
3 Никита Петров Assistant 3500
4 Инна Орлова Accountant 4500

db.createCollection("workers")
db.users.insertMany([
    {
        id: 1,
        firstname: "Петр",
        lastname: "Сергеев",
        position: "CEO",
        salary: 7000
    },
    {
        id: 2,
        firstname: "Виктор",
        lastname: "Семенов",
        position: "Web-developer",
        salary: 5000
    },
    {
        id: 3,
        firstname: "Никита",
        lastname: "Петров",
        position: "Assistant",
        salary: 3500
    },
    {
        id: 4,
        firstname: "Инна",
        lastname: "Орлова",
        position: "Accountant",
        salary: 4500
    }
])

Создать коллекцию fruits и заполнить документами со следующими свойствами: id, title, price, count. Используйте следующие данные:
1 Apple 280 4
2 Lemon 300 8
3 Lime 500 3
4 Orange 200 8

db.createCollection("fruits")
db.fruits.insertMany([
    {
        id: 1,
        title: "Apple",
        price: 280,
        count: 4
    },
    {
        id: 2,
        title: "Lemon",
        price: 300,
        count: 8
    },
    {
        id: 3,
        title: "Lime",
        price: 500,
        count: 3
    },
    {
        id: 4,
        title: "Orange",
        price: 200,
        count: 8
    },
])

Создать коллекцию vegetables и заполнить документами со следующими свойствами: id, title, price, count, country. Используйте следующие данные:
1 Potato 370 5 Germany
2 Onion 320 3 Poland
3 Tomato 210 9 Spain
4 Carrot 280 4 France

db.createCollection("vegetables")
db.vegetables.insertMany([
    {
        id: 1,
        title: "Potato",
        price: 370,
        count: 5,
        country: "Germany"
    },
    {
        id: 2,
        title: "Onion",
        price: 320,
        count: 3,
        country: "Poland"
    },
    {
        id: 3,
        title: "Tomato",
        price: 210,
        count: 9,
        country: "Spain"
    },
    {
        id: 4,
        title: "Carrot",
        price: 280,
        count: 4,
        country: "France"
    },
])