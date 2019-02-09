(ns org.siepe.thomas.roman-numerals)

(defonce roman-2-dec-digit {\I 1 \V 5 \X 10 \L 50 \C 100 \D 500 \M 1000})

(defn to-decimal [roman-numeral]
  (loop [result 0
         previous-digit \A
         vals-rev (reverse roman-numeral)]
        (if-not (seq vals-rev)
          result
          (let [current-digit (first vals-rev)
                dec-current (get roman-2-dec-digit current-digit 0)
                dec-previous (get roman-2-dec-digit previous-digit 0)]
            (recur 
              (if (>= dec-current dec-previous) 
                (+ result dec-current)
                (- result dec-current))
              current-digit
              (rest vals-rev))))))
