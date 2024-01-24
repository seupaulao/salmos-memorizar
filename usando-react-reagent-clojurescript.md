;; This buffer is for text that is not saved, and for Lisp evaluation.
;; To create a file, visit it with C-x C-f and enter text in its buffer.


## Ferramentas

Re-Natal - roda o clojurescript para react native apps

Reagent  - é um react para clojure

Figwheel - fornece o hot reload

##  Configuração

### Instale o re-natal

npm install -g re-natal

### Inicialize o projeto

re-natal init <AppName>

## Rodando

1. dentro do projeto

npm install

2. crie um arquivo local.properties dentro da pasta do android

sdk.dir = /Users/<USERNAME>/Library/Android/sdk

3. rode o emulador do android

cd /Users/USERNAME/Library/Android/sdk/emulator && ./emulator @<EMULATOR_NAME>

Se quiser listar os emuladores disponiveis

emulator -list-avds

4. instale o app no emulador

npm run run-android

## Alterações

### vamos alterar o background color do botão e o texto exibido:

(defn app-root []
  (let [greeting (subscribe [:get-greeting])]
    (fn []
      [view {:style {:flex-direction "column" :margin 40 :align-items "center"}}
       [text {:style {:font-size 30 :font-weight "100" :margin-bottom 20 :text-align "center"}} @greeting]
       [image {:source logo-img
               :style  {:width 80 :height 80 :margin-bottom 30}}]
       [touchable-highlight {:style {:background-color "#13DD1C" :padding 10 :border-radius 5}
                             :on-press #(alert "Hello from clojure!")}
        [text {:style {:color "white" :text-align "center" :font-weight "bold"}} "press me"]]])))


### re-instale a aplicação

npm run run-android

Note que a aaplicação permance igual

O problema é que reconstruimos a aplicação, mas não alteramos o index.android.js

Aqui entra em cena o figwheel - que auxilia o hot reload

Olhando o project.clj eh o mesmo de produção. Não há figwheel. Cada vez que o projeto é
reconstruido ele atualiza o index.android.js e o index.ios.js

### Execute 

lein with-profile prod cljsbuild auto

vai criar a seção prod no project.clj com figwheel:

:profiles {:dev {:dependencies [[figwheel-sidecar "0.5.18"]
                                [cider/piggieback "0.4.0"]]
                             :source-paths ["src" "env/dev"]
                             :cljsbuild    {:builds [
                                                     {:id           "ios"
                                                      :source-paths ["src" "env/dev"]
                                                      :figwheel     true
                                                      :compiler     {:output-to     "target/ios/index.js"
                                                                     :main          "env.ios.main"
                                                                     :output-dir    "target/ios"
                                                                     :optimizations :none
                                                                     :target :nodejs}}
                                                     {:id           "android"
                                                      :source-paths ["src" "env/dev"]
                                                      :figwheel     true
                                                      :compiler     {:output-to     "target/android/index.js"
                                                                     :main          "env.android.main"
                                                                     :output-dir    "target/android"
                                                                     :optimizations :none
                                                                     :target :nodejs}}
#_($DEV_PROFILES$)]}
                             :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}}
                       :prod {:cljsbuild {:builds [
                                                   {:id           "ios"
                                                    :source-paths ["src" "env/prod"]
                                                    :compiler     {:output-to     "index.ios.js"
                                                                   :main          "env.ios.main"
                                                                   :output-dir    "target/ios"
                                                                   :static-fns    true
                                                                   :optimize-constants true
                                                                   :optimizations :simple
                                                                   :target :nodejs
                                                                   :closure-defines {"goog.DEBUG" false}}}
                                                   {:id           "android"
                                                    :source-paths ["src" "env/prod"]
                                                    :compiler     {:output-to     "index.android.js"
                                                                   :main          "env.android.main"
                                                                   :output-dir    "target/android"
                                                                   :static-fns    true
                                                                   :optimize-constants true
                                                                   :optimizations :simple
                                                                   :target :nodejs
                                                                   :closure-defines {"goog.DEBUG" false}}}
#_($PROD_PROFILES$)]}}}




### Para iniciar usando o figwheel - certifique-se que o emulador está rodando antes

1. re-natal use-android-device avd

2. re-natal use-figwheel

3. lein figwheel android

4. npm run run-android