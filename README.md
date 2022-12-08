# web-frameworks

Compare popular web frameworks

What does program do?
1. Generate an id by [SCRU128](https://github.com/scru128/spec)
1. Saving into database
1. Select the latest record from database
1. Serialize into JSON string

## Results
Framework| Language | Package Size(bytes) | Start time(ms) |Mem usage(bytes)
-----|-----|-----|-----|-----
SpringBoot3 MVC w/ Tomcat| Java 18.0.1.1 | 17,705,771 | N/A         |N/A
SpringBoot3 WebFlux| Java 18.0.1.1 | 20,266,871 | N/A         |N/A
Vert.x 4.3| Java 18.0.1.1 | N/A          | N/A         |N/A
Quarkus w/ GraalVM| Java 18.0.1.1 | N/A          | N/A         |N/A
Go w/ net/http library| Go 1.18.3 | 4,410,880 | N/A         |N/A
Go w/ fasthttp library| Go 1.18.3 | N/A          | N/A         |N/A
Axum| Rust 1.62.0 MSVC | 1,259,520 | N/A         |N/A
Warp| Rust 1.62.0 MSVC | 2,220,544 | N/A         |N/A

## Testing env.

**Testing services and benchmarking tool were running on the same laptop.**

Hardwares of Laptop:
```
1. CPU: Intel(R) Core(TM) i3 CPU       M 380  @ 2.53GHz   2.53 GHz
1. RAM: 8G DDR3 (4G * 2)
1. HardDisk: 500G (Not SSD)
```

OS:
```
Windows 10 21H2 x64 Family Edition
```
