(ns dojo.core)

; A dice with a specified number of sides
(defn dice [sides]
  (fn [] ( inc (rand-int sides))))

(defn roll [times sides]
  (take times (repeatedly (dice sides))))

(defn roll-score [times sides]
  (reduce + (roll times sides)))

(defn parse [inputString]
  (let [times (Character/digit (first (first (split-with isNumber inputString))) 10)
        sides (Character/digit (first (first (split-with isNumber (reverse inputString)))) 10)] (roll-score times sides)))

(defn addExtra [value]
  (+ 5 (parse "3d6")))

 (defn isNumber [currentChar]
  (Character/isDigit  currentChar))

