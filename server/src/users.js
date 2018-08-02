var faker = require("faker");
const users = [];
for (let i = 1; i <= 1000; i++) {
  users.push({ 
    id: i,
    name: faker.name.findName()
  });
}
module.exports = users;
