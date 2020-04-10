(ns org.siepe.thomas.max)

(defn max [& values]
  (reduce #(if (> %1 %2) %1 %2) values))

