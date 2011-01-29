(ns dice.core)

(defn roll-die [sides]
  (inc (rand-int sides)))

(defn d
  ([times sides]
     (reduce + (take times (repeatedly #(roll-die sides)))))
  ([times sides extra-fn extra-value]
     (extra-fn (d times sides) extra-value)))

(defn roll-crit-predicate [] (= 20 (d 1 20)))

(defn roll-crit [roll-1 die-1 roll-2 die-2]
  (+ (d roll-1 die-1)
     (if (roll-crit-predicate) (d roll-2 die-2)
         0)))
