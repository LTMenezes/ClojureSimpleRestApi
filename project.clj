(defproject clojure-simple-rest-api "0.1.0-SNAPSHOT"
  :description "Simple Ring REST Api"
  :url "https://github.com/LTMenezes/ClojureSimpleRestApi"
  :license {:name "The MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring/ring-core "1.2.1"]
                 [ring/ring-jetty-adapter "1.2.1"]
                 [compojure "1.1.6"]]
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler clojure-simple-rest-api.core/app
         :nrepl {:start? true
                 :port 10030}}
  :main ^:skip-aot clojure-simple-rest-api.core
  :target-path "target/%s"
  :profiles   {:production {:ring {:open-browser? false
                                   :stacktraces?  false
                                   :auto-reload?  false}}
               :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                    [ring-mock "0.1.5"]]}})
