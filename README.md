### ✅ Checklist de Boas Práticas para Desenvolvimento de APIs

**TODO** 🧪 **Implementar testes automatizados (unitários e funcionais)** -- FEITO, PRETENDO MELHORAR MAIS
- Testes automatizados são essenciais para garantir a qualidade e manutenibilidade do código.
- Evite focar apenas nos "caminhos felizes" — inclua testes para cenários de erro, validações e casos extremos.
- Garanta que os testes sejam efetivos, cobrindo regras de negócio e integrações críticas.

**TODO** 📦 **Containerizar a aplicação**
- Crie um `Dockerfile` para empacotar sua aplicação em um container.
- Defina as dependências, variáveis de ambiente e comandos de execução necessários.
- *Observação:* Não é necessário publicar a imagem em um repositório — apenas torne possível a execução via container.

**TODO** 📜 **Implementar logs informativos e estruturados**
- Adicione logs que mostrem o fluxo da aplicação (ex: requisições recebidas, erros, processamentos).
- Utilize níveis apropriados (INFO, DEBUG, WARN, ERROR) para facilitar a análise.
- Prefira logs estruturados (como JSON) para integração com ferramentas de monitoramento.

**TODO** 🩺 **Adicionar endpoint de healthcheck (verificação de saúde)**
- Crie um endpoint (ex: `GET /health`) que retorne o status da aplicação.
- Inclua informações como: conectividade com banco de dados, uso de recursos ou serviços externos.
- Esse endpoint é essencial para orquestradores (como Kubernetes) e sistemas de monitoramento.

**TODO** 📚 **Documentar a API**
- Utilize padrões como OpenAPI (Swagger) para documentar endpoints, parâmetros, respostas e exemplos.
- Inclua instruções claras de uso, códigos de status e modelos de dados.
- Ferramentas como Swagger UI ou Redoc podem gerar documentação interativa automaticamente.

