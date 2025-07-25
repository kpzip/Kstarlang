/**
 * 
 */
package kjavac.visitor;

import java.util.ArrayList;
import java.util.List;

import kjavac.ast.Identifier;
import kjavac.ast.ParsedFile;
import kjavac.ast.Visibility;
import kjavac.ast.expression.BinaryExpression;
import kjavac.ast.expression.Expression;
import kjavac.ast.expression.FunctionCall;
import kjavac.ast.expression.Literal;
import kjavac.ast.statement.Statement;
import kjavac.ast.statement.StatementList;
import kjavac.ast.statement.VariableAssignment;
import kjavac.ast.statement.VariableDeclarationAssignment;
import kjavac.ast.statement.VariableTypeDeclaration;
import kjavac.ast.statement.declaration.ClassDeclaration;
import kjavac.ast.statement.declaration.Declaration;
import kjavac.ast.statement.declaration.FunctionDeclaration;
import kjavac.ast.statement.declaration.FunctionInfo;
import kjavac.ast.type.BuiltinType;
import kjavac.ast.type.DefinedType;
import kjavac.ast.type.Type;
import kjavac.generated.KStarBaseVisitor;
import kjavac.generated.KStarParser.AssignContext;
import kjavac.generated.KStarParser.Class_declarationContext;
import kjavac.generated.KStarParser.DeclContext;
import kjavac.generated.KStarParser.Decl_assignContext;
import kjavac.generated.KStarParser.DeclarationContext;
import kjavac.generated.KStarParser.ExprContext;
import kjavac.generated.KStarParser.FileContext;
import kjavac.generated.KStarParser.Function_declarationContext;
import kjavac.generated.KStarParser.Function_signatureContext;
import kjavac.generated.KStarParser.StatementContext;
import kjavac.generated.KStarParser.Statement_listContext;
import kjavac.generated.KStarParser.TypeContext;
import kjavac.generated.KStarParser.VisibilityContext;

/**
 * 
 * @author kpzip
 * 
 */
public class TreeVisitor extends KStarBaseVisitor<Object> {

	@Override
	public ParsedFile visitFile(FileContext ctx) {
		List<DeclarationContext> declarations = ctx.declaration();
		List<Declaration> visited = declarations.stream().map(context -> this.visitDeclaration(context)).toList();
		return new ParsedFile(visited);
	}
	
	@Override
	public Declaration visitDeclaration(DeclarationContext ctx) {
		Function_declarationContext func = ctx.function_declaration();
		Class_declarationContext clazz = ctx.class_declaration();
		if (func != null) {
			return this.visitFunction_declaration(func);
		}
		else if (clazz != null) {
			return this.visitClass_declaration(clazz);
		}
		else {
			throw new Error("Rip");
		}
	}
	
	@Override
	public FunctionDeclaration visitFunction_declaration(Function_declarationContext ctx) {
		Function_signatureContext sig = ctx.function_signature();
		FunctionInfo visited = this.visitFunction_signature(sig);
		Statement_listContext stmt = ctx.statement_list();
		return new FunctionDeclaration(visited, stmt == null ? null : this.visitStatement_list(stmt));
	}
	
	@Override
	public ClassDeclaration visitClass_declaration(Class_declarationContext ctx) {
		Visibility vis = this.visitVisibility(ctx.visibility());
		boolean is_enum = ctx.KW_ENUM() != null;
		boolean is_singleton = ctx.KW_SINGLETON() != null;
		Type clazz = this.visitType(ctx.type(0));
		Type super_clazz = null;
		if (ctx.KW_EXTENDS() != null) {
			super_clazz = this.visitType(ctx.type(1));
		}
		List<Type> implements_interfaces = new ArrayList<Type>();
		if (ctx.KW_IMPLEMENTS() != null) {
			implements_interfaces = ctx.type().stream().map(this::visitType).toList();
		}
		List<Declaration> declarations = ctx.declaration().stream().map(this::visitDeclaration).toList();
		return new ClassDeclaration(vis, clazz, super_clazz, implements_interfaces, is_enum, is_singleton, declarations);
	}
	
	@Override
	public FunctionInfo visitFunction_signature(Function_signatureContext ctx) {
		Visibility vis = this.visitVisibility(ctx.visibility());
		Type ret = this.visitType(ctx.type());
		List<VariableTypeDeclaration> params = ctx.decl().stream().map(decl -> this.visitDecl(decl)).toList();
		Identifier name = new Identifier(ctx.ID().getText());
		return new FunctionInfo(vis, ret, params, name);
	}
	
	@Override
	public StatementList visitStatement_list(Statement_listContext ctx) {
		return new StatementList(ctx.statement().stream().map(this::visitStatement).toList());
	}
	
	@Override
	public Type visitType(TypeContext ctx) {
		if (ctx.KW_VOID() != null) {
			return BuiltinType.VOID;
		}
		else if (ctx.KW_BOOL() != null) {
			return BuiltinType.BOOL;
		}
		else if (ctx.KW_BYTE() != null) {
			return BuiltinType.BYTE;
		}
		else if (ctx.KW_UBYTE() != null) {
			return BuiltinType.UBYTE;
		}
		else if (ctx.KW_SHORT() != null) {
			return BuiltinType.SHORT;
		}
		else if (ctx.KW_USHORT() != null) {
			return BuiltinType.USHORT;
		}
		else if (ctx.KW_INT() != null) {
			return BuiltinType.INT;
		}
		else if (ctx.KW_UINT() != null) {
			return BuiltinType.UINT;
		}
		else if (ctx.KW_LONG() != null) {
			return BuiltinType.LONG;
		}
		else if (ctx.KW_ULONG() != null) {
			return BuiltinType.ULONG;
		}
		return new DefinedType(new Identifier(ctx.ID().getText()));
	}
	
	@Override
	public VariableTypeDeclaration visitDecl(DeclContext ctx) {
		Type ty = this.visitType(ctx.type());
		Identifier name = new Identifier(ctx.ID().getText());
		return new VariableTypeDeclaration(ty, name);
	}
	
	@Override
	public Visibility visitVisibility(VisibilityContext ctx) {
		if (ctx.KW_PUBLIC() != null) {
			return Visibility.PUBLIC;
		}
		else if (ctx.KW_PRIVATE() != null) {
			return Visibility.PRIVATE;
		}
		else {
			throw new Error("Rip");
		}
	}
	
	@Override
	public Statement visitStatement(StatementContext ctx) {
		Decl_assignContext c;
		AssignContext a;
		DeclContext d;
		ExprContext e;
		if ((c = ctx.decl_assign()) != null) {
			return this.visitDecl_assign(c);
		}
		else if ((a = ctx.assign()) != null) {
			return this.visitAssign(a);
		}
		else if ((d = ctx.decl()) != null) {
			return this.visitDecl(d);
		}
		else if ((e = ctx.expr()) != null) {
			return this.visitExpr(e);
		}
		else {
			throw new Error("Bruh");
		}
	}
	
	@Override
	public VariableDeclarationAssignment visitDecl_assign(Decl_assignContext ctx) {
		VariableTypeDeclaration decl = this.visitDecl(ctx.decl());
		Expression expr = this.visitExpr(ctx.expr());
		return new VariableDeclarationAssignment(decl, expr);
	}
	
	@Override
	public VariableAssignment visitAssign(AssignContext ctx) {
		Identifier id = new Identifier(ctx.ID().getText());
		Expression expr = this.visitExpr(ctx.expr());
		return new VariableAssignment(id, expr);
	}
	
	@Override
	public Expression visitExpr(ExprContext ctx) {
		if (ctx.ADD() != null || ctx.SUBTRACT() != null || ctx.MULTIPLY() != null || ctx.DIVIDE() != null) {
			Expression lhs = this.visitExpr(ctx.expr(0));
			Expression rhs = this.visitExpr(ctx.expr(1));
			BinaryExpression.Type t;
			if (ctx.ADD() != null) {
				t = BinaryExpression.Type.ADD;
			}
			else if (ctx.SUBTRACT() != null) {
				t = BinaryExpression.Type.SUBTRACT;
			}
			else if (ctx.MULTIPLY() != null) {
				t = BinaryExpression.Type.MULTIPLY;
			}
			else if (ctx.DIVIDE() != null) {
				t = BinaryExpression.Type.DIVIDE;
			}
			else {
				throw new Error("Rip");
			}
			return new BinaryExpression(lhs, rhs, t);
		}
		else if (ctx.DEC_LIT() != null) {
			return new Literal(ctx.DEC_LIT().getText());
		}
		else if (ctx.HEX_LIT() != null) {
			return new Literal(ctx.HEX_LIT().getText());
		}
		else if (ctx.BIN_LIT() != null) {
			return new Literal(ctx.BIN_LIT().getText());
		}
		else if (ctx.STR_LIT() != null) {
			return new Literal(ctx.STR_LIT().getText());
		}
		else if (ctx.L_PAREN() != null && ctx.ID() == null) {
			return this.visitExpr(ctx.expr(0));
		}
		else if (ctx.ID() != null && ctx.L_PAREN() == null) {
			return new Identifier(ctx.ID().getText());
		}
		else if (ctx.ID() != null && ctx.L_PAREN() != null) {
			Identifier id = new Identifier(ctx.ID().getText());
			List<Expression> exprs = ctx.expr().stream().map(this::visitExpr).toList();
			return new FunctionCall(id, exprs);
		}
		else {
			throw new Error("Rip" + ctx.getAltNumber() + " " + ctx.getRuleIndex());
		}
	}
	
}
