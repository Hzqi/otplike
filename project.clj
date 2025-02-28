(def project-version "0.6.1-alpha")

(defproject
  org.clojars.hzqi_110/otplike project-version
  :description "Erlang/OTP like processes and behaviours on top of core.async"
  :url "https://github.com/Hzqi/otplike"
  :license {:name "Eclipse Public License - v1.0"
            :url  "https://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.async "0.4.474"]
                 [org.clojure/core.match "0.3.0-alpha5"]
                 [org.clojure/data.int-map "0.2.4"]
                 [clojure-future-spec "1.9.0"]]

  :source-paths  ["src"]

  ;;:main otplike.example.benchmarks
  ;;:source-paths  ["src" "examples"]

  :profiles {:test
             {:dependencies [[org.clojure/math.combinatorics "0.1.4"]]}

             :uberjar
             {:aot :all}

             :test-parallel
             {:eftest {:multithread? :vars
                       ;; :multithread? :namespaces
                       ;; :multithread? false
                       ;; :multithread? true
                       }
              :java-opts ["-Dclojure.core.async.pool-size=32"]}

             :test-sequentially
             {:eftest {:multithread? false}
              :java-opts ["-Dclojure.core.async.pool-size=1"]}

             :test-1.8
             {:dependencies [[org.clojure/clojure "1.8.0"]]}

             :test-1.9
             {:dependencies [[org.clojure/clojure "1.9.0"]]}

             :test-1.10
             {:dependencies [[org.clojure/clojure "1.10.1"]]}

             :repl
             {:dependencies [[org.clojure/math.combinatorics "0.1.4"]
                             [eftest "0.5.2"]]
              :source-paths  ["src" "examples"]}}

  :test-selectors {:parallel :parallel
                   :serial :serial
                   :all (constantly true)
                   :default (complement :exhaustive)}

  :monkeypatch-clojure-test false)
