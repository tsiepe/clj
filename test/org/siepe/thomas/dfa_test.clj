(ns org.siepe.thomas.dfa-test
  (:require [clojure.test :refer :all]
            [org.siepe.thomas.dfa :refer :all]))

(deftest test-1
  (testing "(= #{\"a\" \"ab\" \"abc\"}
   (set (__ '{:states #{q0 q1 q2 q3}
              :alphabet #{a b c}
              :start q0
              :accepts #{q1 q2 q3}
              :transitions {q0 {a q1}
                            q1 {b q2}
                            q2 {c q3}}})))")
  (is (= #{"a" "ab" "abc"}
         (set (dfa '{:states #{q0 q1 q2 q3}
                    :alphabet #{a b c}
                    :start q0
                    :accepts #{q1 q2 q3}
                    :transitions {q0 {a q1}
                                  q1 {b q2}
                                  q2 {c q3}}})))))

(deftest test-2
  (testing "(= #{\"hi\" \"hey\" \"hello\"}
   (set (__ '{:states #{q0 q1 q2 q3 q4 q5 q6 q7}
              :alphabet #{e h i l o y}
              :start q0
              :accepts #{q2 q4 q7}
              :transitions {q0 {h q1}
                            q1 {i q2, e q3}
                            q3 {l q5, y q4}
                            q5 {l q6}
                            q6 {o q7}}})))"
    (is (= #{"hi" "hey" "hello"}
           (set (dfa '{:states #{q0 q1 q2 q3 q4 q5 q6 q7}
                      :alphabet #{e h i l o y}
                      :start q0
                      :accepts #{q2 q4 q7}
                      :transitions {q0 {h q1}
                                    q1 {i q2, e q3}
                                    q3 {l q5, y q4}
                                    q5 {l q6}
                                    q6 {o q7}}}))))))
