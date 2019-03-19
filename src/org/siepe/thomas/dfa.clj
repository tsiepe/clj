(ns org.siepe.thomas.dfa)

(defn dfa [input]
  (loop [final-states (:accepts input)
         productions []]
    (if-not (seq final-states)
      productions
      (let [wanted-state (first final-states)]
        (recur 
          (rest final-states)
          (conj productions 
              (loop [result ""
                     current-state (:start input)]
                (if (= current-state wanted-state)
                  result
                  (let [all-trans (:transitions input)
                        curr-trans (get all-trans current-state)
                        next-pair (cond 
                                    (some #{wanted-state} (vals curr-trans)) (first (filter (fn [[k v]] (= v wanted-state)) curr-trans))
                                    (contains? all-trans (-> curr-trans first second)) (-> curr-trans first)
                                    :else (first (filter #(contains? all-trans (second %)) curr-trans)))]
                    (recur 
                     (str result (first next-pair))
                     (second next-pair)))))))))))
