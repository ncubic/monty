FROM node:19-alpine

WORKDIR /usr/src/app

COPY . .

RUN npm run build

CMD [ "node", "server.js" ]
