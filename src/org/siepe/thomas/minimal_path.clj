(ns org.siepe.thomas.minimal-path)

(defn calculate [triangle]
  (let [indexed (map (fn [one-row] 
                        (sort-by first 
                          (map-indexed (fn [idx item] [item idx]) one-row))) triangle)
       result-top-down (loop [sum 0
                              previous-idx 0
                              payload indexed]
                         (if (seq payload)
                           (let [current-row (first payload)
                                 candidates (filter #(or (= (second %) previous-idx)
                                                      (= (second %) (+  previous-idx 1))) 
                                                    current-row)]
                             (recur
                                (+ sum (-> candidates first first))
                                (-> candidates first second)
                                (rest payload)))              
                           sum))
      result-bottom-up (loop [sum 0
                              payload (reverse indexed)
                              previous-idx (- (count (first payload)) 1)                           
]
                          (if (seq payload)
                            (let [current-row (first payload)
                                  candidates (filter #(or (= (second %) previous-idx)
                                                       (= (second %) (-  previous-idx 1))) 
                                                     current-row)]
                              (recur
                                (+ sum (-> candidates first first))
                                (rest payload)
                                (-> candidates first second)))              
                            sum))]
          (if (< result-bottom-up result-top-down)
            result-bottom-up
            result-top-down)))

