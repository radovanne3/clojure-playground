(ns snorlax-clojure.playground
  (:gen-class))

(def starwars-characters
  {:luke   {:fullname "Luke Skywarker" :skill "Targeting Swamp Rats"}
   :vader  {:fullname "Darth Vader" :skill "Crank phone calls"}
   :jarjar {:fullname "JarJar Binks" :skill "Upsetting generation of fans"}})

(get starwars-characters :luke)
;; => {:fullname "Luke Skywarker", :skill "Targeting Swamp Rats"}

(:luke starwars-characters)
;; => {:fullname "Luke Skywarker", :skill "Targeting Swamp Rats"}

(get-in starwars-characters [:luke :fullname])
;; => "Luke Skywarker"

(:fullname (:luke starwars-characters))
;; => "Luke Skywarker"

(:skill(:luke starwars-characters))
;; => "Targeting Swamp Rats"

;; updating assoc-in

(assoc-in starwars-characters [:vader :skill] "Lift people up when they are down")


;; threading

(-> starwars-characters
    :luke ,,,
    :fullname ,,,)
;; => "Luke Skywarker"

;; Generate ascii codes

(def alphabet (clojure.string/split "a b c d e f g h i j k l m n o p q r s t u v w x y z" #" "))

(defn generate-ascii-codes
  "Use it to generate ascii code via mapping over english-alphabet and code-range of 65 + alphabet characters count"
  [alphabet code-start]
  (map hash-map
       alphabet
       (range code-start (+ code-start (count alphabet)))))

(generate-ascii-codes alphabet 65)
;; => ({"a" 65} {"b" 66} {"c" 67} {"d" 68} {"e" 69} {"f" 70} {"g" 71} {"h" 72} {"i" 73} {"j" 74} {"k" 75} {"l" 76} {"m" 77} {"n" 78} {"o" 79} {"p" 80} {"q" 81} {"r" 82} {"s" 83} {"t" 84} {"u" 85} {"v" 86} {"w" 87} {"x" 88} {"y" 89} {"z" 90})

(defn generate-ascii-codes-zipmap
  "Use it to generate ascii code via mapping over english-alphabet and code-range of 65 + alphabet characters count, with zipmap"
  [alphabet code-start]
  (zipmap alphabet (range code-start (+ code-start (count alphabet)))))


(generate-ascii-codes-zipmap alphabet 65)
(generate-ascii-codes alphabet 65)
(flatten (generate-ascii-codes alphabet 65))


(map keyword (map str (range 10)))


(defn generate-map-verbose
  [size-of-map]
  (let [numbers (range size-of-map)
        str-nums (map #(str %) numbers)
        keys (map #(keyword %) str-nums)]
    (zipmap keys numbers)))

(generate-map-verbose 10)


