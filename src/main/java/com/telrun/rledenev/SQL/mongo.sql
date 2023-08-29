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
- `$unset` удалить поля
- `$inc` инкремент значений
- `$mul` умножение
- `$push` добавить элементы в массив
- `$addToSet` добавить элементы в **множество**
- `$pull` удалить элементы из массива
- `$pullAll` удалить несколько элементов из массива
- `$each` (используется в связке c `$push` и `$addToSet`)


Логические операторы
Логические операторы выполняются над условиями выборки:

$or: соединяет два условия, и документ должен соответствовать одному из этих условий

$and: соединяет два условия, и документ должен соответствовать обоим условиям

$not: документ должен НЕ соответствовать условию

$nor: соединяет два условия, и документ должен НЕ соответстовать обоим условиям

## **Операторы сравнения при работе со списком значений**

- `$in` принадлежность к списку значений
- `$nin` (not in)

2. Заполнить коллекцию workers 5 документами со свойствами id, firstname, lastname, age, position, salary, skills. Используйте следующие данные:
    1. Inga Petrova, 27, Barista, 1500, [’preparing drinks’, ‘cleaning equipment’]
    2. Boris Orlov, 36, Server, 2400, [’taking orders’, ‘suggesting meals’, ‘taking payments’]
    3. Ivan Demidov, 32, Chef, 3200, [’preparing food’, ‘baking bread’]
    4. Marina Sidorova, 22, Hostess, 1700, [’greeting guests’, ‘seating guests’, ‘answering phone calls’]
    5. Olga Ivanova, 43, Sommelier, 2500, [’curating a wine list’, ‘creating wine pairings’]

db.workers.insertMany([
    {id: 1, firstname: "Inga", lastname: "Petrova", age: 27, position: "Barista", salary: 1500, skills: ["preparing drinks", "cleaning equipment"]},
    {id: 2, firstname: "Boris", lastname: "Orlov", age: 36, position: "Server", salary: 2400, skills: ["taking orders", "suggesting meals", "taking payments"]},
    {id: 3, firstname: "Ivan", lastname: "Demidov", age: 32, position: "Chef", salary: 3200, skills: ["preparing food", "baking bread"]},
    {id: 4, firstname: "Marina", lastname: "Sidorova", age: 22, position: "Hostess", salary: 1700, skills: ["greeting guests", "seating guests", "answering phone calls"]},
    {id: 5, firstname: "Olga", lastname: "Ivanova", age: 43, position: "Sommelier", salary: 2500, skills: ["curating a wine list", "creating wine pairings"]}
])

db.workers.find({id: {$eq: 3}}, {firstname: 1, lastname: 1})
db.workers.find({salary: {$gt: 2000}}, {firstname: 1, salary: 1})
db.workers.find({salary: {$gt: 2000}, age: {$lt: 40}}, {firstname: 1, salary: 1, age: 1})
db.workers.find({$and: [
{salary: {$lte: 2500}},
 {salary: {$gte: 1800}}
 ]})

db.workers.find({salary: {$lte: 2500, $gte: 1800}}, {firstname: 1, salary: 1, age: 1})

db.workers.find({age: {$ne: 27}}, {firstname: 1, salary: 1, age: 1})
db.workers.find({$or: [
{position: "Barista"},
{position: "Chef"}]}, {firstname: 1, salary: 1, position: 1})

db.workers.find({position: {$in: ["Barista", "Chef"]}})

db.workers.find({skills: {$all: ["taking orders", "taking payments"]}})

db.workers.find({skills: {$in: ["preparing drinks", "baking bread"]}})

db.workers.find({skills: {$nin: ["preparing drinks", "baking bread"]}})

db.workers.updateOne(
{id: 1},
{$set: {lastname: "Smit"}}
)

db.workers.updateOne(
{id: 1},
{$set: {position: "Head Server"}}
)

db.workers.updateOne(
{firstname: "Marina", lastname: "Sidorova"},
{$set: {age: 23}}
)

db.workers.updateMany(
{salary: {$gt: 2000}},
{$set: {age: 35}}
)

db.workers.updateOne(
{id: 2},
{$mul: {age: 1.5}})

db.workers.updateMany({}, {$mul: {salary: 1.1}})

db.workers.updateOne(
{id: 1},
{$push: {skills: "drink vodka"}})

db.workers.updateOne(
{id: 3},
{$push: {skills: "serving desserts"}})

db.workers.updateMany(
{},
{$pull: {skills: "taking payments"}})

db.workers.updateMany(
{id: 1},
{$inc: {salary: 300}})

db.workers.updateMany(
{},
{$inc: {age: -4}})

db.workers.updateMany({}, {$rename: {"position": "job"}})

                                                                                          use socialnetwork;

db.users.insertMany([
{ _id: 1, fullname: 'hacker111', country: 'Germany' },
{ _id: 2, fullname: 'user 2', country: 'USA' },
{ _id: 3, fullname: 'user 3', country: 'China' }])

db.users.find({country: {$eq: 'China'}})

db.users.find({country: {$ne: 'China'}})

db.users.updateMany(
{country: {$eq: 'China'}},
{$set: {is_blocked: true}}
)

db.users.find(
{is_blocked: {$ne: true}},
{fullname: 1, _id: 0})

db.users.updateMany(
{is_blocked: true},
{$unset: {is_blocked: null}})

db.users.updateOne(
{_id: 1},
{$addToSet: {tag: 'admin'}}
)

db.transactions.insertMany([{
        sender_id: 1,
        recipient_id: 2,
        amount: 100,
        currency: "eur",
        is_completed: true
    },
    {
        sender_id: 2,
        recipient_id: 3,
        amount: 50,
        currency: "eur",
        is_completed: false
    },
    {
        sender_id: 2,
        recipient_id: 1,
        amount: 70,
        currency: "usd",
        is_completed: true
    },
    {   sender_id: 3,
        recipient_id: 1,
        amount: 100,
        currency: "usd",
        is_completed: true
    },
    {   sender_id: 1,
        recipient_id: 3,
        amount: 100,
        currency: "usd",
        is_completed: false
    }
    ]);

db.transactions.find({});

db.transactions.aggregate([]);

db.transactions.aggregate([{
    $match: {currency: {$eq: "usd"}}
}]);

db.transactions.aggregate([{
    $match: {currency: {$eq: "eur"}}
},
{
    $sort: { amount: -1 }
},
{
    $limit: 1
}
]);

db.transactions.aggregate([{
    $match: {
        currency: {$eq: "eur"},
        amount: {$lt: 1000}
    }
},
{
    $sort: { amount: -1 }
},
{
    $skip: 1
},
{
    $limit: 1
}
]);

