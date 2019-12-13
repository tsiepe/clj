(ns org.siepe.thomas.max)

(defn max [& values]
  (loop [candidate (first values)
         rest-of-list values]
    (if-not (> (count rest-of-list) 1)
      candidate
      (recur (if (> candidate (second rest-of-list))
               candidate
               (second rest-of-list))
             (rest rest-of-list)))))

