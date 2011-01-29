(ns dice.test.core
  (:use [dice.core] :reload)
  (:use [clojure.test]))

(defn roll-fixture [f]
  (binding [dice.core/roll-die (fn [n] n)]
    (f)))

(deftest roll-d6
  (is (= 6
         (roll-die 6))))

(deftest roll-3d6
  (is (= 18
         (d 3 6))))

(deftest roll-2d12
  (is (= 24
         (d 2 12))))

(deftest roll-1d20
  (is (= 20
         (d 1 20))))

(deftest roll-3d6+5
  (is (= 23
         (d 3 6 + 5))))

(deftest roll-3d6div2
  (is (= 9
         (d 3 6 / 2))))



(use-fixtures :once roll-fixture)
