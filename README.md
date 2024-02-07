### Projeto Salmo para memorizar - React, Reagent, ClojureScript

- esse projeto é um webapp
- NÃO destina-se a android ou iOS

### criar aplicação

npx create-cljs-project my-project

### help

npx shadow-cljs help

### compile a build once and exit

shadow-cljs compile app

### compile and watch

shadow-cljs watch app

### connect to REPL for the build (available while watch is running)

shadow-cljs cljs-repl app

### connect to standalone node repl

shadow-cljs node-repl

### release build

shadow-cljs release app

### Release debugging commands.

shadow-cljs check app

shadow-cljs release app --debug

### server

shadow-cljs server

or (if you'd like REPL to control the server process)

shadow-cljs clj-repl

### server control

shadow-cljs start

shadow-cljs stop

shadow-cljs restart
