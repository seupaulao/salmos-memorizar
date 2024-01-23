(ns salmos.core
  (:require [salmos.livro :as livro])
  (:require [reagent.dom :as dom]))


(defn init []
  (println (salmos.livro/getlivro "PSA_23_1")))

(defonce cap 23)

(defonce ver 1)

(defn Application[] 
  [:div

   [:h2 "Salmos para Memorizar"]

   [:span (salmos.livro/getlivro (str "PSA_" cap "_" ver)) ] 

   [:div
    [:button "-10"]
    [:button "Anterior"]
    [:button "Próximo"]
    [:button "+10"]
    ]
   ]
  )

(dom/render [Application] (js/document.getElementById "app"))