(ns org.siepe.thomas.max-test
  (:require [clojure.test :refer :all]
            [org.siepe.thomas.max :refer :all]))


(deftest test-1
  (testing "(= (__ 1 8 3 4) 8))"
    (is (= 8 (max 1 8 3 4)))))

(deftest test-2
  (testing "(= (__ 30 20) 30)"
    (is (= 30 (max 30 20)))))

(deftest test-3
  (testing "(= (__ 45 67 11) 67)"
    (is (= 67 (max 45 67 11)))))
