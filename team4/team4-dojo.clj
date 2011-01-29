(defn dice-roll [num-sides]
  (+ 1 (rand-int num-sides)))

(defn roll-n-die
  ([num-sides num-die]
     (roll-n-die num-sides num-die identity))
  ([num-sides num-die modifier]
     (modifier (reduce + (repeat (dice-roll num-sides) num-die)))))

(defn sum-roll
  [dice]
  (reduce + (map #(roll-n-die (first %) (second %)) dice)))

(defn hash-dice
  [num-sides num-die modifier]
  (modifier (sum-roll {num-sides num-die})))
  