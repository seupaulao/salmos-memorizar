(ns salmos.core
  (:require [salmos.livro :as livro])
  (:require [reagent.dom :as dom])
  (:require [reagent.core :as r]))

(def cap (r/atom 23))

(def ver (r/atom 1))

(defn init []
  (println (salmos.livro/getlivro (str "PSA_" @cap "_" @ver))))

;; criar funcionalidade aos botões]
(defn pra-frente [n]
  (do
     (swap! ver #(+ % n))
     (when (> @ver (salmos.livro/qte-versos @cap))  
         (do
            (reset! ver (- @ver (salmos.livro/qte-versos @cap))) 
            (swap! cap inc) 
            ))
     (when (> @cap 150) (do (reset! ver 1) (reset! cap 1)))       
  )  
)

(defn pra-tras [n]
   (do
     (swap! ver #(- % n))
     (when (<= @ver 0)  
         (do
            (swap! cap dec) 
            (reset! ver (+ (salmos.livro/qte-versos @cap) @ver)) 
            ))
     (when (<= @cap 1) (do (reset! ver 1) (reset! cap 1)))       
  )  
)

;; trabalhar o CSS
(defn Application[] 
  [:div.w3-center

    [:div.w3-container.w3-gray
      [:h2 {:style {:color "blue"}} "Salmos para Memorizar"]
    ]
      
   [:div.w3-panel.w3-sand.w3-xlarge.w3-serif
      [:span (str @cap ":" @ver "  ") ]
      [:span (salmos.livro/getlivro (str "PSA_" @cap "_" @ver)) ]
   ] 
    
   [:div.w3-panel
      [:input.w3-button.w3-yellow {:type "button" :value "-5" :on-click #(pra-tras 5)} ]
      [:input.w3-button.w3-indigo {:type "button" :value "Anterior" :on-click #(pra-tras 1)}]
      [:input.w3-button.w3-indigo {:type "button" :value "Próximo" :on-click #(pra-frente 1)}]
      [:input.w3-button.w3-yellow {:type "button" :value "+5" :on-click #(pra-frente 5)} ]
   ]
   ]
  )
  ;; gravar na memoria o verso e o campitulo

  ;; fazer a funcao IR-PARA

  ;; fazer tratamento dos dados de entrada

(dom/render [Application] (js/document.getElementById "app"))