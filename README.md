### Projeto Salmo para memorizar - React, Reagent, ClojureScript

- esse projeto é um webapp
- NÃO destina-se a android ou iOS

### arquitetura

- shadow-cljs
- reagent
- openjdk 21+

### criar aplicação

npx create-cljs-project my-project

### help

npx shadow-cljs help

### compile a build once and exit

npx shadow-cljs compile app

### compile and watch

npx shadow-cljs watch app

### connect to REPL for the build (available while watch is running)

npx shadow-cljs cljs-repl app

### connect to standalone node repl

npx shadow-cljs node-repl

### release build

npx shadow-cljs release app

### Release debugging commands.

npx shadow-cljs check app

npx shadow-cljs release app --debug

### server

npx shadow-cljs server

or (if you'd like REPL to control the server process)

npx shadow-cljs clj-repl

### server control

npx shadow-cljs start

npx shadow-cljs stop

npx shadow-cljs restart
