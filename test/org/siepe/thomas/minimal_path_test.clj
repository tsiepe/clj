(ns org.siepe.thomas.minimal-path-test
  (:require [clojure.test :refer :all]
            [org.siepe.thomas.minimal-path :refer :all]))

(deftest test-1
  (testing "(= 7 (__ '([1]
                      [2 4]
                     [5 1 4]
                    [2 3 4 5]))) ; 1->2->1->3"
    (is (= 7 (calculate '([1]
                        [2 4]
                       [5 1 4]
                      [2 3 4 5]))))))

(deftest test-2
  (testing "(= 20 (__ '([3]
                       [2 4]
                      [1 9 3]
                     [9 9 2 4]
                    [4 6 6 7 8]
                   [5 7 3 5 1 4])))"
    (is (= 20 (calculate '([3]
                         [2 4]
                        [1 9 3]
                       [9 9 2 4]
                      [4 6 6 7 8]
                     [5 7 3 5 1 4]))))))

