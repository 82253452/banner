"use strict";
var $___46__46__47_private_46_js__;
var $__2 = ($___46__46__47_private_46_js__ = require("../private.js"), $___46__46__47_private_46_js__ && $___46__46__47_private_46_js__.__esModule && $___46__46__47_private_46_js__ || {default: $___46__46__47_private_46_js__}),
    createPrivateSymbol = $__2.createPrivateSymbol,
    getPrivate = $__2.getPrivate,
    setPrivate = $__2.setPrivate;
var $TypeError = TypeError;
var $__1 = Object,
    create = $__1.create,
    defineProperties = $__1.defineProperties,
    defineProperty = $__1.defineProperty;
function nonEnum(value) {
  return {
    configurable: true,
    enumerable: false,
    value: value,
    writable: true
  };
}
var ST_NEWBORN = 0;
var ST_EXECUTING = 1;
var ST_SUSPENDED = 2;
var ST_CLOSED = 3;
var END_STATE = -2;
var RETHROW_STATE = -3;
function getInternalError(state) {
  return new Error('Traceur compiler bug: invalid state in state machine: ' + state);
}
var RETURN_SENTINEL = {};
function GeneratorContext() {
  this.state = 0;
  this.GState = ST_NEWBORN;
  this.storedException = undefined;
  this.finallyFallThrough = undefined;
  this.sent_ = undefined;
  this.returnValue = undefined;
  this.oldReturnValue = undefined;
  this.tryStack_ = [];
}
GeneratorContext.prototype = {
  pushTry: function(catchState, finallyState) {
    if (finallyState !== null) {
      var finallyFallThrough = null;
      for (var i = this.tryStack_.length - 1; i >= 0; i--) {
        if (this.tryStack_[i].catch !== undefined) {
          finallyFallThrough = this.tryStack_[i].catch;
          break;
        }
      }
      if (finallyFallThrough === null)
        finallyFallThrough = RETHROW_STATE;
      this.tryStack_.push({
        finally: finallyState,
        finallyFallThrough: finallyFallThrough
      });
    }
    if (catchState !== null) {
      this.tryStack_.push({catch: catchState});
    }
  },
  popTry: function() {
    this.tryStack_.pop();
  },
  maybeUncatchable: function() {
    if (this.storedException === RETURN_SENTINEL) {
      throw RETURN_SENTINEL;
    }
  },
  get sent() {
    this.maybeThrow();
    return this.sent_;
  },
  set sent(v) {
    this.sent_ = v;
  },
  get sentIgnoreThrow() {
    return this.sent_;
  },
  maybeThrow: function() {
    if (this.action === 'throw') {
      this.action = 'next';
      throw this.sent_;
    }
  },
  end: function() {
    switch (this.state) {
      case END_STATE:
        return this;
      case RETHROW_STATE:
        throw this.storedException;
      default:
        throw getInternalError(this.state);
    }
  },
  handleException: function(ex) {
    this.GState = ST_CLOSED;
    this.state = END_STATE;
    throw ex;
  },
  wrapYieldStar: function(iterator) {
    var ctx = this;
    return {
      next: function(v) {
        return iterator.next(v);
      },
      throw: function(e) {
        var result;
        if (e === RETURN_SENTINEL) {
          if (iterator.return) {
            result = iterator.return(ctx.returnValue);
            if (!result.done) {
              ctx.returnValue = ctx.oldReturnValue;
              return result;
            }
            ctx.returnValue = result.value;
          }
          throw e;
        }
        if (iterator.throw) {
          return iterator.throw(e);
        }
        iterator.return && iterator.return();
        throw $TypeError('Inner iterator does not have a throw method');
      }
    };
  }
};
function nextOrThrow(ctx, moveNext, action, x) {
  switch (ctx.GState) {
    case ST_EXECUTING:
      throw new Error(("\"" + action + "\" on executing generator"));
    case ST_CLOSED:
      if (action == 'next') {
        return {
          value: undefined,
          done: true
        };
      }
      if (x === RETURN_SENTINEL) {
        return {
          value: ctx.returnValue,
          done: true
        };
      }
      throw x;
    case ST_NEWBORN:
      if (action === 'throw') {
        ctx.GState = ST_CLOSED;
        if (x === RETURN_SENTINEL) {
          return {
            value: ctx.returnValue,
            done: true
          };
        }
        throw x;
      }
      if (x !== undefined)
        throw $TypeError('Sent value to newborn generator');
    case ST_SUSPENDED:
      ctx.GState = ST_EXECUTING;
      ctx.action = action;
      ctx.sent = x;
      var value;
      try {
        value = moveNext(ctx);
      } catch (ex) {
        if (ex === RETURN_SENTINEL) {
          value = ctx;
        } else {
          throw ex;
        }
      }
      var done = value === ctx;
      if (done)
        value = ctx.returnValue;
      ctx.GState = done ? ST_CLOSED : ST_SUSPENDED;
      return {
        value: value,
        done: done
      };
  }
}
var ctxName = createPrivateSymbol();
var moveNextName = createPrivateSymbol();
function GeneratorFunction() {}
function GeneratorFunctionPrototype() {}
GeneratorFunction.prototype = GeneratorFunctionPrototype;
defineProperty(GeneratorFunctionPrototype, 'constructor', nonEnum(GeneratorFunction));
GeneratorFunctionPrototype.prototype = {
  constructor: GeneratorFunctionPrototype,
  next: function(v) {
    return nextOrThrow(getPrivate(this, ctxName), getPrivate(this, moveNextName), 'next', v);
  },
  throw: function(v) {
    return nextOrThrow(getPrivate(this, ctxName), getPrivate(this, moveNextName), 'throw', v);
  },
  return: function(v) {
    var ctx = getPrivate(this, ctxName);
    ctx.oldReturnValue = ctx.returnValue;
    ctx.returnValue = v;
    return nextOrThrow(ctx, getPrivate(this, moveNextName), 'throw', RETURN_SENTINEL);
  }
};
defineProperties(GeneratorFunctionPrototype.prototype, {
  constructor: {enumerable: false},
  next: {enumerable: false},
  throw: {enumerable: false},
  return: {enumerable: false}
});
Object.defineProperty(GeneratorFunctionPrototype.prototype, Symbol.iterator, nonEnum(function() {
  return this;
}));
function createGeneratorInstance(innerFunction, functionObject, self) {
  var moveNext = getMoveNext(innerFunction, self);
  var ctx = new GeneratorContext();
  var object = create(functionObject.prototype);
  setPrivate(object, ctxName, ctx);
  setPrivate(object, moveNextName, moveNext);
  return object;
}
function initGeneratorFunction(functionObject) {
  functionObject.prototype = create(GeneratorFunctionPrototype.prototype);
  functionObject.__proto__ = GeneratorFunctionPrototype;
  return functionObject;
}
function AsyncFunctionContext() {
  GeneratorContext.call(this);
  this.err = undefined;
  var ctx = this;
  ctx.result = new Promise(function(resolve, reject) {
    ctx.resolve = resolve;
    ctx.reject = reject;
  });
}
AsyncFunctionContext.prototype = create(GeneratorContext.prototype);
AsyncFunctionContext.prototype.end = function() {
  switch (this.state) {
    case END_STATE:
      this.resolve(this.returnValue);
      break;
    case RETHROW_STATE:
      this.reject(this.storedException);
      break;
    default:
      this.reject(getInternalError(this.state));
  }
};
AsyncFunctionContext.prototype.handleException = function() {
  this.state = RETHROW_STATE;
};
function asyncWrap(innerFunction, self) {
  var moveNext = getMoveNext(innerFunction, self);
  var ctx = new AsyncFunctionContext();
  ctx.createCallback = function(newState) {
    return function(value) {
      ctx.state = newState;
      ctx.value = value;
      moveNext(ctx);
    };
  };
  ctx.errback = function(err) {
    handleCatch(ctx, err);
    moveNext(ctx);
  };
  moveNext(ctx);
  return ctx.result;
}
function getMoveNext(innerFunction, self) {
  return function(ctx) {
    while (true) {
      try {
        return innerFunction.call(self, ctx);
      } catch (ex) {
        handleCatch(ctx, ex);
      }
    }
  };
}
function handleCatch(ctx, ex) {
  ctx.storedException = ex;
  var last = ctx.tryStack_[ctx.tryStack_.length - 1];
  if (!last) {
    ctx.handleException(ex);
    return;
  }
  ctx.state = last.catch !== undefined ? last.catch : last.finally;
  if (last.finallyFallThrough !== undefined)
    ctx.finallyFallThrough = last.finallyFallThrough;
}
Object.defineProperties(module.exports, {
  createGeneratorInstance: {get: function() {
      return createGeneratorInstance;
    }},
  initGeneratorFunction: {get: function() {
      return initGeneratorFunction;
    }},
  asyncWrap: {get: function() {
      return asyncWrap;
    }},
  __esModule: {value: true}
});
