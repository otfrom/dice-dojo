(ns hello-world
  (:use clojure.test)
  (:import (java.lang Math)))

(defn roll [generator]
  (generator))

(defn roll-dice [n die]
  (reduce + (map roll (repeat n die))))

(defn modify-roll-dice
  ([roll-dice modifier modifier-arg]
    (apply modifier [roll-dice modifier-arg])))

(defn d [n]
  (fn [] (inc (rand-int n))))

(defn mul
  ([n die] (mul n die + 0))
  ([n die op mod] (fn [] (modify-roll-dice (reduce + (map roll (repeat n die))) op mod) )))

(deftest sum-is-returned-by-roll-die
  (is (= 9 (roll (mul 3 (constantly 3))))))

(deftest roll-2d12
  (doall
    (map
      (fn [_] (is (< 1 (roll (mul 2 (d 12))) 25)))
      (range 1000))
    ))

;; 2d10


(deftest test-roll-dice-modification
  (let [result 10
        modifier /
        argument 2]
    (is (= 5 (modify-roll-dice result modifier argument)))))

(run-tests 'hello-world)

; (d 2 3 (m / 4)) d6 + 3