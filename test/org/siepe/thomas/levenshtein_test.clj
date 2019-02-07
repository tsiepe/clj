(ns org.siepe.thomas.levenshtein-test
  (:require [clojure.test :refer :all]
            [org.siepe.thomas.levenshtein :refer :all]))

(deftest test-1
  (testing "(= (__ \"kitten\" \"sitting\") 3)"
    (is (= (distance "kitten" "sitting") 3))))

(deftest test-2
  (testing "(= (__ \"closure\" \"clojure\") 1) and vice-versa"
    (and 
      (is (= (distance "closure" "clojure") 1))
      (is (= (distance "clojure" "closure") 1)))))

(deftest test-3
  (testing "(= (__ \"xyx\" \"xyyyx\") 2)"
    (is (= (distance "xyx" "xyyyx") 2))))

(deftest test-4
  (testing "(= (__ \"\" \"123456\") 6)"
    (is (= (distance "" "123456") 6))))

(deftest test-5
  (testing "(= (__ \"Clojure\" \"Clojure\") (__ \"\" \"\") (__ [] []) 0)"
    (and 
      (is (= (distance "Clojure" "Clojure") 0))
      (is (= (distance "" "") 0))
      (is (= (distance [] []) 0)))))

(deftest test-6
  (testing "(= (__ [1 2 3 4] [0 2 3 4 5]) 2)"
    (is (= (distance [1 2 3 4] [0 2 3 4 5]) 2))))

(deftest test-7
  (testing "(= (__ '(:a :b :c :d) '(:a :d)) 2)"
    (is (= (distance '(:a :b :c :d) '(:a :d)) 2))))

(deftest test-8
  (testing "(= (__ \"ttttattttctg\" \"tcaaccctaccat\") 10)"
    (is (= (distance "ttttattttctg" "tcaaccctaccat") 10))))

(deftest test-9
  (testing "(= (__ \"gaattctaatctc\" \"caaacaaaaaattt\") 9)"
    (is (= (distance "gaattctaatctc" "caaacaaaaaattt") 9))))

