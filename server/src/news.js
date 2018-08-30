var faker = require("faker");
const news = [];
for (let i = 1; i <= 1000; i++) {
  news.push({ 
    id: i,
    title: faker.name.findName()
  });
}
module.exports = news;
