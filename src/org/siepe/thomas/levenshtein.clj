(ns org.siepe.thomas.levenshtein)

(defn distance [origin target]
  (cond

   (= origin target)
   0

   (= (count origin) 0)
   (count target)

   (= (count target) 0)
   (count origin)

   (= (count origin) (count target))
   (reduce + (map (fn [el1 el2] (if (= el1 el2) 0 1)) target origin))

   (not= (count origin) (count target))
   (let [len-tar (count target)
        len-orig (count origin)
        [orig tar] (if (> len-tar len-orig)
                      [origin target]
                      [target origin])
        hits-in-tar (loop [orig orig
                          misses '()
                          hits-in-tar 0
                          curr-tar-idx 0]
                      (if (= curr-tar-idx (count tar))
                        hits-in-tar
                        (let [lookup-el (first orig)
                              found (= (nth tar curr-tar-idx) lookup-el)
                              lookup-miss (first misses)
                              found-in-misses (= (nth tar curr-tar-idx) lookup-miss)]
                          (recur
                                  (rest orig)
                                  (if found
                                    misses
                                    (if found-in-misses
                                      (rest misses)
                                      (if lookup-el
                                        (cons lookup-el misses)
                                        misses)))
                                  (if (or found found-in-misses)
                                    (inc hits-in-tar)
                                    hits-in-tar)
                                  (inc curr-tar-idx)))))]
     (- (count tar) hits-in-tar))))

