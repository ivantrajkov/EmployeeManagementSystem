FROM node:alpine

RUN mkdir /app

ADD . /app

WORKDIR /app

RUN npm install

EXPOSE 3000

CMD npm run dev -- --host 0.0.0.0 --port 3000
