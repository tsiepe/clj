(ns org.siepe.thomas.roman-numerals-test
  (:require [clojure.test :refer :all]
            [org.siepe.thomas.roman-numerals :refer :all]))

(deftest test-1
  (testing "(= 14 (__ \"XIV\"))"
    (is (= 14 (to-decimal "XIV")))))

(deftest test-2
  (testing "(= 827 (__ \"DCCCXXVII\"))"
    (is (= 827 (to-decimal "DCCCXXVII")))))

(deftest test-3
  (testing "(= 3999 (__ \"MMMCMXCIX\"))"
    (is (= 3999 (to-decimal "MMMCMXCIX")))))

(deftest test-4
  (testing "(= 48 (__ \"XLVIII\"))"
    (is (= 48 (to-decimal "XLVIII")))))

