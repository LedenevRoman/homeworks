use tmp;
db.createCollection("users")
db.users.insertMany([
    {
        id: 1,
        name: "Анатолий",
        lastname: "Ушанов",
        age: 31
    },
    {
        id: 2,
        name: "Максим",
        lastname: "Грибов",
        age: 33
    },
    {
        id: 3,
        name: "Антон",
        lastname: "Куликов",
        age: 30
    }
])

db.users.find()


db.createCollections("workers")

id, firstname, lastname, position, salary. Используйте следующие данные:

1 Петр Сергеев CEO 7000
2 Виктор Семенов Web-developer 5000
3 Никита Петров Assistant 3500
4 Инна Орлова Accountant 4500


db.workers.insertMany([
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
    },
])

Операторы сравнения
gt - >
lt - <
gte - >=
lte - <=
eq - =
ne - <>



db.workers.find({firstname: {$eq: 'Инна'}})

db.workers.find({salary: {$gte: 5000}})
db.workers.find({position: {$ne: "Web-developer"}})

db.workers.find({$or: [{salary: 3500}, {salary: 7000}]})
db.workers.find({$or: [{id: {$eq: 3}}, {position: {$eq: "CEO"}}]})

db.workers.find({$and: [
{salary: {$gte: 3500}},
{position: {$ne: "CEO"}}
]})

db.workers.find({salary: {$in: [7000, 3500]}})
db.workers.find({position: {$in: ["CEO", "Web-developer"]}})

db.workers.find({$or: [
    {id: {$nin: [1, 2, 4]}},
    {salary: {$eq: 4500}}
    ]})


db.clients.find(
    { country: 'China' }, // filter
    { fullname: 1, _id: 0 } // projection
)

db.clients.countDocuments(
    { country: 'China' } // filter
)

db.clients.updateOne(
    { _id: ObjectId("64ae94b961b6ed0378795984") }, // filter
    { // action
        $set: {
            is_blocked: true
        }
    }
)

## Основыне операторы модификации

- `$set` установить поля
- `$inc` инкремент значений
- `$mul` умножение
- `$push` добавить элементы в массив
- `$addToSet` добавить элементы в множество
- `$pull` удалить элементы из массива
- `$pullAll` удалить несколько элементов из массива
- `$each` (используется в связке c `$push` и `$addToSet`)


Логические операторы
Логические операторы выполняются над условиями выборки:

$or: соединяет два условия, и документ должен соответствовать одному из этих условий

$and: соединяет два условия, и документ должен соответствовать обоим условиям

$not: документ должен НЕ соответствовать условию

$nor: соединяет два условия, и документ должен НЕ соответстовать обоим условиям