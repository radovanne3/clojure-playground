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

(println "Test")



;; CALLING JAVA INSIDE CLOJURE


(def rnd (new java.util.Random))


(. rnd nextInt 10)
;; => 3
;; => 0
;; => 7
;; => 3

;; Instance field
(def p (java.awt.Point. 10 20))

(. p x)
;; => 10

(. p y)
;; => 20

;; Static method

(. System lineSeparator)
;; => "\n"


;; Static field

(. Math PI)
;; => 3.141592653589793

;; In case that both method and field have same name, method  will be preferred, In that case we use this notation (.p -x)

(. p -x)
;; => 10

;; HERE IS MORE SIMPLE VERSION OF FORMS WRITTEN ABOVE, LETS DO IT CLOJURE WAY

(.nextInt rnd 10)
;; => 8

(.x p)
;; => 10

(defn sim-clc-test
  [a b]
  (+ a b))

(sim-clc-test 5 5)

(.nextInt rnd (sim-clc-test 5 5))

;; Well this is interesting

(.nextInt rnd (* Math/PI 10))
;; => 1
;; => 9
;; => 1
;; => 21
;; => 10



;; FLOW CONTROL ( IMPORTANT )

;; BRANCH WITH IF

(defn is-small?
  [number]
  (if (< number 50)
    "LARGER"
    "SMALLER"))


(is-small? 60)
;; => "SMALLER"

(is-small? 30)
;; => "LARGER"


;; RECUR/ LOOP RECUR

(loop [result [] x 10]
  (if (zero? x)
    result
    (recur (conj result x) (dec x))))

(defn indexed
  [coll]
  (map-indexed vector coll))

(indexed "abcde")
;; => ([0 \a] [1 \b] [2 \c] [3 \d] [4 \e])









































































