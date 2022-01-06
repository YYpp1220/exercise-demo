// 默认批量导出函数
export default {
    sum : (a, b) => a + b,
    ride : (a, b) => a * b,
    reduce : (a, b) => a - b,
    except : (a, b) => a / b,
    maximum : array => Math.max(...array),
    minimum : array => Math.min.apply(null, array)
}